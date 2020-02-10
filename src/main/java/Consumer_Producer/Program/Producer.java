package Consumer_Producer.Program;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producer implements Constants, RandomInterface, Runnable {

    public static int food;

    private int tempo;
    private int milTempo;
    private int nanoTempo;
    private int magazineCapacity;
    private boolean isTrue;
    private int testingTime;

    public Producer(int tempo, int magazineCapacity) throws Exception {
        if(magazineCapacity > 0 && tempo > 0) {
            this.magazineCapacity = magazineCapacity;
            this.tempo = tempo;
        }else{
            System.err.println(Constants.BAD_INPUT_MESSAGE);
            throw new Exception(Constants.BAD_INPUT_MESSAGE);
        }
        if( tempo >= 900_000 ) {
            milTempo = tempo / 1_000_000;
            nanoTempo = tempo % 900_000;
        }else{
            nanoTempo = tempo;
            milTempo = 0;
        }
        food = Constants.ZERO;
        isTrue = true;
    }

    public synchronized void run() {
        long startTime = System.nanoTime();

        while (isTrue) {
            if(testingTime > 1) {
                isTrue = methodToTime(testingTime, startTime);
            }
            try {
                Thread.sleep(milTempo, randomValue(nanoTempo));
                if (food < magazineCapacity) {
                    food += Constants.FOOD_PER_TEMPO;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean methodToTime(long testingTime, long startTime){
        long oneSec = 1_000_000_000;
        long endTime = System.nanoTime();
        long durationInNano = (endTime - startTime);
        return durationInNano < (testingTime * oneSec);
    }
}
