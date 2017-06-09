public class Tamagotchi{
    public String nome;
    public int idade, peso, x, w;

    public Tamagotchi (String nome, int idade, int peso)
    {   this.nome = nome;
        this.idade = idade;
        this.peso = peso;
    }
    //métodos de acesso
    public int getW()
    {   return w;
    }
    
    public void setW(int w)
    {   this.w = w;
    }

    public int getIdade()
    {   return idade;
    }

    public int getPeso()
    {  return peso;
    }

    public void setPeso(int peso)
    {   this.peso = peso;
    }

    public void setIdade(int idade)
    {   this.idade = idade;
    }

    public void verificaPeso()
    {   if (peso<=0)
            System.out.println("\f"+nome+" morreu de inanição :(");
        else if (peso>20)
            System.out.println("\f"+nome+" explodiu, você o alimentou demais :'(");
    }

    public void imprimeInfo()
    {   String x = ("");
        if (idade>14)
            x = ("e está velhinho, com "+idade+" dia(s).\nAproveite bem o último dia de vida de seu amigo.\n");
        else if (idade<=1)
            x = ("e ainda é um bebe, com "+idade+" dia(s).\nSeja um bom dono ao longo da vida  de seu amiguinho!\n");
        else
            x = ("e está com "+idade+" dia(s)\n");

        if (peso>15)
            System.out.print("\n"+nome+" está gordinho, que tal fazer um regime?\nEle pesa "+peso+"kg "+x);
        else if (peso<3)
            System.out.print("\n"+nome+" está anorexico, que tal alimentar mais o seu bichinho?\nEle pesa "+peso+"kg "+x);
        else if (peso>=3 && peso<8)
            System.out.print("\n"+nome+" está magrinho, pesa "+peso+"kg "+x);
        else
            System.out.print("\n"+nome+" está pesando "+peso+"kg "+x);
    }

    public void sentirSono(int s)
    {   if (s==1)
        {
            if (idade==15)
                System.out.println("\f"+nome+" ficou velhinho e faleceu, parabens por ter sido um bom dono durante a vida de seu amiguinho!");
            else{
                idade++;
                if (idade!=15)
                    imprimeInfo();
                else
                    System.out.println("\f"+nome+" ficou velhinho e faleceu, parabens por ter sido um bom dono durante a vida de seu amiguinho!");
            }
        }
        else
        {
            if (w!=5)
                imprimeInfo();
        }
    }

    public void ficarEntediado(int e)
    {
        if (e==1)
        {
            peso-=4;
            if (peso<=20 && peso>0){
                imprimeInfo();
                System.out.println("\n"+nome+" correu por 10 minutos e por isso resolveu encher a pança comendo muito.");
                sentirFome(1);
            }
            else
                verificaPeso();
        }
        else
        {
            peso--;
            if (peso>0)
            {
                imprimeInfo();
                System.out.println("\n"+nome+" caminhou por 10 minutos e por isso está com fome.");
            }
            else
                verificaPeso();
        }
    }

    public void sentirFome(int f)
    {   if (f==1)
        {
            if (peso<=20)
            {
                peso +=5;
                if (peso>20)
                    verificaPeso();
                else
                {
                    imprimeInfo();
                    System.out.println("\n"+nome+" comeu muito, por isso ficou cansado e foi dormir."); 
                    sentirSono(1);
                }
            }
            else
                verificaPeso();
        }
        else if (f==2)
        {
            peso++;
            if (peso<=20)
                imprimeInfo();
            else
                verificaPeso();
        }
        else
        {
            peso-=2;
            if (peso>0)
                imprimeInfo();
            else
                verificaPeso();
        }
    }
}
