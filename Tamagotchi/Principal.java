public class Principal
{   
    private int k;

    public void setK(int k)
    {   this.k = k;
    }

    public void verificaVariavel()
    {   if (k==0)
            k++;
        else
            System.out.print("\nVocê digitou um valor invalido. Por favor, digite um dos numeros solicitados.");
    }

    public static void main(String args[])
    {   Principal principal = new Principal();
        Teclado teclado = new Teclado();

        System.out.println("O Tamagotchi foi um brinquedo muito usado em meados dos anos 90.\nO brinquedo consiste em um animalzinho de estimação eletrônico");
        System.out.println("que deve ser cuidado para que não morra.\nQue tal criar o seu e começar a brincar agora mesmo?");

        String nome = teclado.leString("\nPor favor, digite o nome do seu Tamagotchi: ");
        int idade = 0;
        int peso = 1;
        Tamagotchi t = new Tamagotchi(nome, idade, peso);
        System.out.println("Nasceu o seu Tamagoschi "+nome+", ele tem "+idade+" dias de idade e pesa "+peso+" kg.");

        int w = 0;
        t.setW(0);
        int j = 4;
        while (j==4)
        {   
            j=(int)(Math.random()*3+1);
            principal.setK(0);
            if (j==1)
            {
                if (peso<=20)
                {
                    int s = 0;
                    while (s!=1 && s!=2)
                    {
                        principal.verificaVariavel();
                        s = teclado.leInt("\n"+nome+" está com sono, você deseja que ele:\n- Durma (Digite 1)\n- Permaneça acordado (Digite 2)");    
                    }
                    if (t.getIdade()<15)
                    {
                        t.sentirSono(s);
                        if (s==1)
                        {
                            if (t.getIdade()<15)
                            {
                                w=0;
                                j=4;
                            }
                        }
                        else{
                            if (t.getIdade()!=15){
                                if (w==5)
                                {
                                    System.out.println("\n"+nome+" permaneceu muitas vezes acordado e por isso foi dormir");
                                    w=0;
                                    t.sentirSono(1);
                                    if (t.getIdade()<15)
                                        j=4;
                                }
                                else
                                {
                                    w++;
                                    j=4;
                                }
                            }
                        }
                    }
                }
            }
            else if (j==3)
            {
                if (t.getPeso()==1)
                    j=4;
                else
                {
                    int e = 0;
                    while (e!=1 && e!=2)
                    {
                        principal.verificaVariavel();
                        e =  teclado.leInt("\n"+nome+" está entediado, você deseja que ele:\n- Corra por 10 minutos (Digite 1),\n- Caminhe por 10 minutos(Digite 2)");
                    }
                    t.ficarEntediado(e);
                    if(e==2)
                    {
                        if (t.getPeso()>0){
                            principal.setK(0);
                            j=2;
                        }
                    }
                    else
                    {
                        if (t.getIdade()!=15 && (t.getPeso()<=20 && t.getPeso()>0))
                            j=4;
                    }
                }
            }
            while (j==2)
            {
                if (t.getPeso()<=0)
                {
                    t.verificaPeso();
                    j=0;
                }
                else
                {
                    int f = 0;
                    while (f!=1 && f!=2 && f!=3)
                    {
                        principal.verificaVariavel();
                        f =  teclado.leInt("\n"+nome+" está com fome, você deseja que ele:\n- Coma  muito(Digite 1),\n- Coma pouco(Digite 2),\n- Não coma(Digite 3)");
                    }
                    t.sentirFome(f);
                    if (t.getIdade()==15 || t.getPeso()>20 || t.getPeso()<=0)
                        j=0;
                    else
                        j=4;
                }
            }
        }
    }
}