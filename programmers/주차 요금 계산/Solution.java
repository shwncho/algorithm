import java.util.*;
import java.io.*;

class Car {
    //시각
    int minute;
    //차량번호
    String carNumber;
    //입출차 기록(내역)
    String record;

    public Car(int minute, String carNumber, String record){
        this.minute = minute;
        this.carNumber = carNumber;
        this.record = record;
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        StringTokenizer st;
        int[] answer={};

        //차량 번호, 누적 주차 시간
        Map<String,Integer> result = new HashMap<>();

        ArrayList<Car> list = new ArrayList<>();
        ArrayList<String> cars= new ArrayList<>();
        for(int i=0; i<records.length; i++){
            st = new StringTokenizer(records[i]);

            String time = st.nextToken();

            int minute = timeToMinute(time);
            String carNumber = st.nextToken();
            String record = st.nextToken();

            if(!cars.contains(carNumber))   cars.add(carNumber);

            if(record.equals("IN")) list.add(new Car(minute, carNumber, record));
            else{
                for(int j=0; j<list.size(); j++){
                    Car c = list.get(j);
                    if(c.carNumber.equals(carNumber)){
                        result.put(carNumber, result.getOrDefault(carNumber,0)+Math.abs(minute - c.minute));
                        list.remove(j);
                        break;
                    }
                }
            }
        }

        if(list.size()!=0){
            for(Car c : list){
                result.put(c.carNumber, result.getOrDefault(c.carNumber,0)+Math.abs(timeToMinute("23:59") - c.minute));
            }
        }



        Collections.sort(cars);
        answer = new int[cars.size()];


        for(int i=0; i<cars.size(); i++){
            int sum = 0;
            if(result.get(cars.get(i))<fees[0]) sum+=fees[1];
            else {
                sum += fees[1];
                sum += Math.ceil((double)(result.get(cars.get(i)) - fees[0]) / fees[2]) * fees[3];
            }

            answer[i] = sum;
        }

        return answer;
    }

    public static int timeToMinute(String time){
        String[] str = time.split(":");
        int result = 0;
        result += Integer.parseInt(str[0]) * 60;
        result += Integer.parseInt(str[1]);

        return result;
    }
}