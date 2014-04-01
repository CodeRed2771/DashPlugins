package pong.logic;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pong.utils.Entity;

/**
 *
 * @author Michael
 */
public class EntityLogic implements Runnable {

    private ArrayList<Entity> entities;
    public boolean shouldRun = false;

    public EntityLogic() {
        entities = new ArrayList<>();
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public void reset() {
        entities = new ArrayList<>();
    }
    
    public ArrayList<Entity> getEntities(){
        return entities;
    }

    @Override
    public void run() {
        while (shouldRun) {
            for (int i = 0; i < entities.size(); i++) {
                Entity entity = entities.get(i);
                entity.move();
                for (int k = 0; k < entities.size(); k++) {
                    Entity anotherEntity = entities.get(k);
                    if (entity.getHitbox().intersects(anotherEntity.getHitbox()) && entity != anotherEntity) {
                        entity.collision(anotherEntity);
                        anotherEntity.collision(entity);
                    }
                }
            }
            try {
                Thread.sleep(6);
            } catch (InterruptedException ex) {
                Logger.getLogger(EntityLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void terminateEntity(Entity entity){
        removeEntity(entity);
    }

    public void start() {
        Thread t = new Thread(this);
        t.setName("Entity Logic Thread");      
        t.start();
    }
}
