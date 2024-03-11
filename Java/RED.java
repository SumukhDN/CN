//Random Early Detection (RED) congestion control java program.

import java.util.Random;

public class RED{
        private static final int q_size=10;
        private static final int max_pkt=20;
        private static final double max_prob=0.7;
        private static final double min_prob=0.3;
        
        private static double randDouble(double min,double max){
            Random rand = new Random();
            return min+(max-min)*rand.nextDouble();
        }
        public static void main(String args[]){
            int qsize=0;
            double dp = min_prob;
            for(int i=0 ; i<max_pkt ; i++){
                if(qsize==q_size){
                    System.out.println((i+1)+" Packet Dropped(queue full)\n");
                    dp=min_prob;
                }
                else if(randDouble(0,1) < dp){
                    System.out.println((i+1)+" Packet Dropped (random)\n");
                    dp += (max_prob-min_prob)/(max_pkt-1);
                }
                else{
                    System.out.println((i+1)+" Packet Accepted\n");
                    qsize++;
                    dp=min_prob;
                }
            }
        }
        
}
