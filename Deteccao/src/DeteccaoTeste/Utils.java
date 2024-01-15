// Pacote do projeto
package DeteccaoTeste;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Mat;

// Classe utilitária para operações relacionadas a imagens e GUI
public class Utils {

    /**
     * Converte um objeto Mat do OpenCV para uma BufferedImage.
     *
     * @param mat Objeto Mat a ser convertido.
     * @return A imagem BufferedImage resultante.
     */
    public BufferedImage convertMatToImage(Mat mat) {
        int type = BufferedImage.TYPE_BYTE_GRAY;

        // Verifica se a matriz tem mais de um canal para determinar o tipo de imagem
        if (mat.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }

        int bufferSize = mat.channels() * mat.cols() * mat.rows();
        byte[] bytes = new byte[bufferSize];
        mat.get(0, 0, bytes);

        // Cria uma BufferedImage com base no tipo determinado
        BufferedImage imagem = new BufferedImage(mat.cols(), mat.rows(), type);

        // Obtém os pixels de destino da imagem e copia os bytes da matriz
        byte[] targetPixels = ((DataBufferByte) imagem.getRaster().getDataBuffer()).getData();
        System.arraycopy(bytes, 0, targetPixels, 0, bytes.length);

        return imagem;
    }

    /**
     * Exibe uma imagem em uma nova janela usando Java Swing.
     *
     * @param imagem A imagem a ser exibida.
     */
    public void mostraImagem(BufferedImage imagem) {
        ImageIcon icon = new ImageIcon(imagem);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(imagem.getWidth() + 50, imagem.getHeight() + 50);

        // Adiciona uma JLabel com o ícone da imagem à janela
        JLabel lbl = new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);

        // Configurações da janela
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
