package Ass2_DesPat;

// كلاس Player
public class Player {
    private DataBus dataBus;
    private Position position;
    private Score score;
    private String name;
    
    public Player(String name, DataBus dataBus) {
        this.name = name;
        this.dataBus = dataBus;
        this.position = new Position(10, 20);
        this.score = new Score();
    }
    
    // setters و getters لل position وال score
    public void setPosition(Position position) {
        this.position = position;
        dataBus.update(this, "position", position);
    }
    
    public void setScore(Score score) {
        this.score = score;
        dataBus.update(this, "score", score);
    }
    
    public Position getPosition() {
        return position;
    }
    
    public Score getScore() {
        return score;
    }
    
    public String getName() {
        return name;
    }
    
    // إرسال البيانات إلى DataBus
    public void sendData(String field, Object value) {
        dataBus.update(this, field, value);
    }
    
    // استقبال البيانات من DataBus
    public void receiveData(String field, Object value) {
        if(field.equals("position")) {
            this.position = (Position) value;
        } else if (field.equals("score")) {
            this.score = (Score) value;
        }
    }
}