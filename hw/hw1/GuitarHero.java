import synthesizer.GuitarString;

/**
 * @author Dylan
 * @version 1.0
 * @date 2019/11/15
 */

public class GuitarHero {
    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] args) {

        GuitarString[] concerts = new GuitarString[37];
        for (int i = 0; i < concerts.length; i += 1) {
            concerts[i] = new GuitarString(440 * Math.pow(2, (i - 24) / 12.0));
        }

//        synthesizer.GuitarString string = new synthesizer.GuitarString(concerts[0]);

        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();

                int index = keyboard.indexOf(key);
                if (index == -1) {
                    continue;
                }
                //string = new synthesizer.GuitarString(concerts[index]);
                //string.pluck();
                concerts[index].pluck();
            }

            /* compute the superposition of samples */
            double sample = 0;
            for (int i = 0; i < concerts.length; i++) {
                sample += concerts[i].sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int i = 0; i < concerts.length; i++) {
                concerts[i].tic();
            }
        }


    }
}
