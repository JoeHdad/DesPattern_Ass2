package Ass2_DesPat;

// كلاس DataBus
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBus {
    private Map<Player, List<String>> subscribers = new HashMap<>();
    private Map<String, Object> data = new HashMap<>();
    
    // الاشتراك في DataBus
    public void subscribe(Player player, String field) {
        if(subscribers.containsKey(player)) {
            subscribers.get(player).add(field);
        } else {
            List<String> fields = new ArrayList<>();
            fields.add(field);
            subscribers.put(player, fields);
        }
    }
    
    // التحديث على DataBus
    public void update(Player player, String field, Object value) {
        data.put(field, value);
        List<Player> players = new ArrayList<>(subscribers.keySet());
        for(Player p : players) {
            if(p != player && subscribers.get(p).contains(field)) {
                p.receiveData(field, value);
            }
        }
    }
    
    // جلب البيانات من DataBus
    public Object getData(String field) {
        return data.get(field);
    }
}
