package Ass2_DesPat;

// الكلاس Main
public class Main {
    public static void main(String[] args) {
        // إنشاء DataBus
        DataBus dataBus = new DataBus();
        
        // إنشاء اللاعبين
        Player player1 = new Player("Player 1", dataBus);
        Player player2 = new Player("Player 2", dataBus);
        
        // اشتراك اللاعبين في DataBus
        dataBus.subscribe(player1, "position");
        dataBus.subscribe(player2, "position");
        dataBus.subscribe(player1, "score");
        dataBus.subscribe(player2, "score");
        
        // تحديث موقع اللاعبين ورصيدهما
        Position position1 = new Position(10, 20);
        player1.setPosition(position1);
        Score score1 = new Score();
        score1.setScore(100);
        player1.setScore(score1);
        
        Position position2 = new Position(30, 40);
        player2.setPosition(position2);
        Score score2 = new Score();
        score2.setScore(50);
        player2.setScore(score2);
        
        // جلب موقع اللاعب الأول ورصيده
        System.out.println(player1.getName() + " position: (" + player1.getPosition().getX() + ", " + player1.getPosition().getY() + ")");
        System.out.println(player1.getName() + " score: " + player1.getScore().getScore());
        
        // جلب موقع اللاعب الثاني ورصيده
        System.out.println(player2.getName() + " position: (" + player2.getPosition().getX() + ", " + player2.getPosition().getY() + ")");
        System.out.println(player2.getName() + " score: " + player2.getScore().getScore());
    }
}