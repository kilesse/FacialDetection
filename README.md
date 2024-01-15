# Projeto de Detecção Facial em Java com OpenCV

Bem-vindo ao meu primeiro projeto em Java dedicado à fascinante área de visão computacional! Este projeto é uma implementação simples, mas poderosa, de detecção facial em tempo real, utilizando a popular biblioteca OpenCV. Sua criação marca um passo significativo no aprendizado do desenvolvimento Java e é motivo de orgulho pessoal.

## Objetivo

O principal objetivo deste projeto é explorar a integração do Java com a OpenCV para criar uma aplicação que realiza detecção facial em tempo real através da câmera do computador. A detecção facial é uma tarefa fundamental na visão computacional, com amplas aplicações que vão desde segurança até interações mais intuitivas em sistemas computacionais.

## Pré-requisitos

Antes de começar, é necessário garantir que os seguintes componentes estejam instalados no seu ambiente de desenvolvimento:

- **OpenCV:** A biblioteca de visão computacional. Siga as instruções de instalação detalhadas disponíveis no [site oficial do OpenCV](https://opencv.org/).

- **Java:** Certifique-se de ter a versão 8 ou superior instalada no seu sistema.

- **IDE Java:** Utilize uma IDE Java, como o [Eclipse](https://www.eclipse.org/) ou [NetBeans](https://netbeans.apache.org/), para facilitar o desenvolvimento.

## Configuração do Projeto

1. Clone ou faça o download do repositório para o seu ambiente local.

2. Abra o projeto na sua IDE Java.

3. Verifique se o caminho para o classificador Haar Cascade está configurado corretamente no código (`WebCam.java`).

## Estrutura do Projeto

O projeto segue uma estrutura organizada para facilitar a compreensão e manutenção do código:

- **DeteccaoTeste:** Pacote principal contendo o código-fonte do projeto.
  - `WebCam.java`: Implementação da interface gráfica e captura de vídeo.
  - `Utils.java`: Classe utilitária para conversão de Mat para BufferedImage e exibição de imagens.

## Funcionalidades

### Detecção Facial

A aplicação utiliza o classificador Haar Cascade para identificar rostos na imagem em tempo real. Essa funcionalidade proporciona uma experiência visual interessante e serve como introdução ao vasto campo da visão computacional.

### Exibição Gráfica

O vídeo da câmera é apresentado em uma interface gráfica intuitiva. A utilização de elementos visuais facilita a compreensão do processo de detecção facial e torna a aplicação mais amigável.

## Como Usar

1. Execute a classe `WebCam.java`.

2. Certifique-se de que a sua câmera está operacional.

3. A janela será aberta, exibindo o vídeo da câmera com a detecção facial em tempo real.

## Contribuições

Contribuições são incentivadas! Se você identificar problemas, tiver sugestões ou quiser adicionar novos recursos, sinta-se à vontade para enviar pull requests ou abrir issues no GitHub.

## Licença

Este projeto é licenciado sob a [MIT License](LICENSE).

## Agradecimentos

Agradeço por explorar meu projeto! Espero que esta experiência contribua para o seu crescimento em desenvolvimento Java. Se tiver dúvidas ou feedback, não hesite em entrar em contato. Boa jornada no mundo da programação!
