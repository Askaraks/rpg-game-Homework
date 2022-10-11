import java.util.Random;

public class Main {
    public static int[] heroesHealth = {270, 280, 260};
    public static int[] heroesDamage = {20, 15, 25};
    public static String[] heroesAttackType = {" Physical ", " Magical ", " Kinetic ", " Medic "};
    public static int medicHeal = 30;

    public static int bossHealth = 800;
    public static int bossDamage = 50;
    public static String bossAttackType = "";
    public static int roundNumber = 0;

    public static void main(String[] args) {
        printStatistics();
        while (!isGameFinished()) {
            round();
        }

    }
    public static void printStatistics(){
        System.out.println(roundNumber + " ROUND ********");
        System.out.println(" Boss health " + bossHealth + " [ " + bossDamage + " ] " );
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i]+" Hero health " + heroesHealth[i] +
                    " [ " + heroesDamage[i] + " ] " );
        }

        System.out.println();


    }
    public static void round(){
        roundNumber++;
        chooseBossAttackType();
        bossHits();
        heroesHit();
        printStatistics();
        help();



    }
    public static void bossHits(){
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] < bossDamage){
                heroesHealth[i] = 0;
            } else {
            heroesHealth[i] = heroesHealth[i] - bossDamage; }


        }


    }
    public static void heroesHit(){
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if(bossAttackType == heroesAttackType[i]) {
                    Random r = new Random();
                    int coef = r.nextInt(3)+2;
                    int heroCriticalDamage = heroesDamage[i]*coef;

                    if(bossHealth < heroesDamage[i]*coef){
                        bossHealth = 0;
                    } else {
                        bossHealth = bossHealth - heroesDamage[i]*coef;
                    }
                    System.out.println("Critical damage:"+heroCriticalDamage + " Hero attack type:"
                            + heroesAttackType[i]);
                } else {
                    if(bossHealth < heroesDamage[i]){
                        bossHealth = 0;

                    } else {
                        bossHealth = bossHealth - heroesDamage[i];
                    }
                }

            bossHealth = bossHealth - heroesDamage[i];
            }


        }

    }
    public static boolean isGameFinished(){
        if (bossHealth <= 0){
            System.out.println("Heroes win!");
            return true;
        }
        if(heroesHealth[0] <=0 && heroesHealth[1] <=0 && heroesHealth[1] <=0){
            System.out.println("Boss wins!");
            return true;
        }
        return false;
    }
    public static void chooseBossAttackType(){
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length);
        bossAttackType = heroesAttackType[randomIndex];
    }
    public static void help() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 20 && heroesHealth[i] < 100){
                Random r = new Random();
                int randomNumber = r.nextInt(12);
                for (int j = 0; j < randomNumber; j++) {
                    heroesHealth[i] = heroesHealth[i] + medicHeal;
                    System.out.println("Help: " + heroesAttackType[i]);
                    break;




                }


            }

        }
        }


    }
