document.ready = function() {

var descricao = "

O jogo será desenvolvido através do software Unity, que é uma plataforma voltada para o desenvolvimento de jogos com diversos recursos à sua disposição. 

Um software nada mais é do que um programa executado em computadores, construído para resolver determinado problema.

A escolha dele se deve à facilidade de utilização, facilidade de aprendizagem e aos pacotes de funcionalidades que a ferramenta já oferece. Não será, por exemplo, necessário criar um sistema de colisões do zero, uma vez que já temos bibliotecas dedicadas aos tratamentos de colisões. Além disso, o Unity é uma ferramenta de uso gratuito, havendo apenas algumas considerações e taxas referentes à comercialização de produtos desenvolvidos através dele.

É importante ressaltar que o Unity não apenas não é a única ferramenta disponível no mercado, como talvez não seja a melhor. Cada projeto pede um pacote de recursos diferente, e a escolha do material a ser utilizado depende das necessidades do desenvolvedor. Uma das fortes concorrentes dele é a Unreal Engine, utilizada em diversos títulos de empresas líderes de mercado, como "Kingdom Hearts III", desenvolvido pela Square Enix em parceria com a Disney. Uma lista dos jogos desenvolvidos em cada ferramenta pode ser encontrada através dos links abaixo:
Unity: URL
UE4: URL

O Unity permite que seja realizado desenvolvimento em diversas linguagens diferentes. Optei pela C# pela familiaridade e capacidades dela.

O sistema de combate pode ser considerado o "coração" do projeto. Uma vez que uma das principais interações dele é aquela entre o jogador e as criaturas, todos os mecanismos desde o monitoramento de um raio de agressividade até o combate em si são de suma importância. Assim, definimos alguns pontos aqui:

O raio de agressividade é aquele que representa a distância dentro da qual uma criatura enxerga o jogador, e se aproxima dele para iniciar um combate.

O início do combate se dá pela colisão entre uma criatura e o personagem controlável. Ele é definido pelo carregamento de um cenário visto lateralmente, o instanciamento das criaturas no cenário de combate, isto é, a criação delas naquele ambiente, e o instanciamento do personagem controlável no cenário.

A criatura terá uma seleção de golpes disponíveis, e seu comportamento será controlado através de uma técnica de inteligência artificial denominada "Árvore de Comportamento". Ela será responsável por controlar sua movimentação e decisões.

O combate ocorre até que os pontos de vida da criatura ou do jogador cheguem a zero, ou abaixo. Os pontos de vida são reduzidos a cada golpe recebido, através de um cálculo de dano aplicado. A fórmula para cálculo de dano será a seguinte:

DMG = (ATK * MULT) - DEF

Onde DMG representa o dano calculado, ATK representa os pontos de ataque do atacante, DEF representa os pontos de defesa do atingido e MULT é um multiplicador baseado no golpe utilizado. Caso dano calculado resulte em um valor menor do que um, será arredondado para um.

Caso o jogador derrote a criatura em combate, ele ganha uma quantidade de pontos de experiência referentes à criatura enfrentada. Se a quantidade de experiência total acumulada for suficiente para atingir o próximo nível, o jogador recebe um ponto de status para atribuir aos atributos de vida, ataque ou defesa. Após a atribuição, o combate é finalizado, e o personagem é retornado ao cenário principal.

A transição entre cenários é outra preocupação relevante, uma vez que queremos que o personagem retorne ao cenário principal na mesma posição em que estava quando transicionou para o combate.

A árvore de comportamento possui uma série de nós, que podem representar uma sequência, uma seleção ou uma folha. Sua verificação é feita de cima para baixo, e da esquerda para direita. Tome como exemplo a árvore abaixo:

[Ilustração]

Como podemos observar, cada folha é representada pelo nó ao final de um galho, isto é, um caminho da árvore. Esse nó representa um comportamento, uma ação a ser executada, uma condição a ser avaliada.

Uma sequência representa um conjunto de ações que será executado em ordem, da esquerda para direita. Uma seleção representa que será escolhido, baseado em uma probabilidade atribuída a cada folha, um comportamento a ser executado. Tome como exemplo a árvore abaixo, ilustrando um comportamento de exemplo:

[Ilustração]

O nó em destaque "sequência" possui três filhos, que serão executados um após o outro.

";

};
