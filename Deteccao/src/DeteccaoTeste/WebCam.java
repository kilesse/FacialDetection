// Pacote do projeto
package DeteccaoTeste;

// Importações necessárias
import static org.opencv.imgcodecs.Imgcodecs.imread;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

// Classe principal que estende JFrame para a aplicação gráfica
public class WebCam extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private VideoCapture captura;
    private volatile boolean fecharJanela = false;

    /**
     * Método principal para iniciar a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Criando uma instância da classe WebCam
                    WebCam frame = new WebCam();

                    // Carregando a biblioteca nativa do OpenCV
                    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

                    // Tornando a janela visível
                    frame.setVisible(true);

                    // Definindo o tamanho inicial da janela
                    frame.setSize(550, 500);

                    // Inicializando a captura da câmera
                    frame.inicializaCamera();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Método construtor da classe WebCam.
     */
    public WebCam() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        // Adicionando um ouvinte de evento para fechar a janela
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent winEvt) {
                fecharJanela = true;
                if (captura != null && captura.isOpened()) {
                    // Liberando a captura ao fechar a janela
                    captura.release();
                }
            }
        });
    }

    /**
     * Método para inicializar a câmera.
     */
    public void inicializaCamera() {
        Mat video = new Mat();

        // Inicializando a captura de vídeo com a câmera no índice 1
        captura = new VideoCapture(1);

        // Verificando se a captura foi aberta com sucesso
        if (captura.isOpened()) {
            // Iniciando uma nova thread para exibir o vídeo
            new Thread(() -> mostraVideo(video)).start();
        }
    }

    /**
     * Método para exibir o vídeo e realizar a detecção facial.
     */
    public void mostraVideo(Mat video) {
        while (!fecharJanela) {
            // Capturando um quadro de vídeo
            captura.read(video);
            if (!video.empty()) {
                // Ajustando o tamanho da janela com base nas dimensões do vídeo
                setSize(video.width(), video.height());

                // Convertendo a imagem colorida para tons de cinza
                Mat imagemColorida = video;
                Mat imagemCinza = new Mat();
                Imgproc.cvtColor(imagemColorida, imagemCinza, Imgproc.COLOR_BGR2GRAY);

                // Carregando o classificador para detecção facial
                CascadeClassifier classificador = new CascadeClassifier("src\\cascades\\haarcascade_frontalface.xml");

                MatOfRect facesDetectadas = new MatOfRect();

                // Detectando rostos na imagem em tons de cinza
                classificador.detectMultiScale(imagemCinza, facesDetectadas, 1.03, 7, 0, new Size(20, 30), new Size(1000, 1000));

                System.out.println(facesDetectadas.toArray().length);

                // Desenhando retângulos ao redor dos rostos detectados na imagem colorida
                for (Rect rect : facesDetectadas.toArray()) {
                    System.out.println(rect.x + " " + rect.y + " " + rect.width + " " + rect.height);
                    Imgproc.rectangle(imagemColorida, new Point(rect.x, rect.y),
                            new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255), 2);
                }

                // Convertendo a imagem para BufferedImage e exibindo na janela
                BufferedImage imagem = new Utils().convertMatToImage(video);
                Graphics g = contentPane.getGraphics();
                g.drawImage(imagem, 0, 1, imagem.getWidth(), imagem.getHeight(), null);
            }
        }

        // Liberando a captura de vídeo ao fechar a janela
        if (captura.isOpened()) {
            captura.release();
        }
    }
}
