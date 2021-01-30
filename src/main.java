import java.util.*;

public class main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

        String[] colors = {"♠", "♣", "♦", "♥" };

        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "k", "A" };

        int index = 0;
        for (String number : numbers) {
            for (String color : colors) {
                hashMap.put(index, color + number);
                arrayList.add(index);
                index++;
            }
        }

        hashMap.put(52, "小王");
        hashMap.put(53, "大王");

        Collections.shuffle(arrayList);

        TreeSet<Integer> player1=new TreeSet<Integer>();
        TreeSet<Integer> player2=new TreeSet<Integer>();
        TreeSet<Integer> player3=new TreeSet<Integer>();
        TreeSet<Integer> bottomCard=new TreeSet<Integer>();



        for (int i = 0; i < arrayList.size(); i++) {
            int poker = arrayList.get(i);

            if (i >= arrayList.size() - 3) {
                bottomCard.add(poker);
            } else if (i % 3 == 0) {
                player3.add(poker);
            } else if (i % 3 == 1) {
                player2.add(poker);
            } else if (i % 3 == 2) {
                player1.add(poker);
            }
        }
        look(player1,hashMap);
        look(player2,hashMap);
        look(player3,hashMap);
        look(bottomCard,hashMap);

    }

    public static void look(TreeSet<Integer> treeSet,HashMap<Integer,String> hashMap) {
        for (int poker : treeSet) {
            System.out.print(hashMap.get(poker)+" ");
        }
        System.out.println();
    }
}

