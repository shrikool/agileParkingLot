package shrikant.algorithms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockInterview {

    public static void main(String[] args) {
        List<Integer> source = new ArrayList<>();
        source.add(1);
        source.add(2);
        source.add(4);
        source.add(6);
        List<Integer> destination = new ArrayList<>();
        destination.add(3);
        destination.add(3);
        destination.add(3);
        destination.add(4);
        List<Integer> returnCity = connectedCities(6, 1, source, destination);

        for (Integer i : returnCity){
            System.out.println(i);
        }
    }

    static List<Integer> connectedCities(int n, int g, List<Integer> originCities, List<Integer> destinationCities){
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++){
            List<Integer> connectedC = new ArrayList<>();
            for (int j = i+1; j<=n; j++){
                if (gcdThing(i,j) > g){
                    connectedC.add(j);
                }
            }
            map.put(i, connectedC);
        }

        List<Integer> returnList = new ArrayList<>();

        for (int i = 0; i < originCities.size(); i++){
            List<Integer> connectedC = getAllConnectedCities(originCities.get(i), map, new ArrayList<>());
            List<Integer> connectedI = getAllConnectedCities(destinationCities.get(i), map, new ArrayList<>());
            /*boolean toAdd = false;
            for (Integer ind : connectedC){
                if (connectedI.contains(ind)){
                    toAdd = true;
                    break;
                }
            }*/
           connectedC.addAll(connectedI);
            if (connectedC.contains(destinationCities.get(i))){
                returnList.add(1);
            }else{
                returnList.add(0);
            }
        }

        return returnList;
    }

    static List<Integer> getAllConnectedCities(int originCity, Map<Integer, List<Integer>> cityMap, List<Integer> visitedCity){
        visitedCity.add(originCity);
        List<Integer> imdCntdCity = cityMap.get(originCity);
        List<Integer> indirectCntdCity = new ArrayList<>();
        for (Integer conCity : imdCntdCity){
            if (!visitedCity.contains(conCity)){
                indirectCntdCity.addAll(getAllConnectedCities(conCity, cityMap, visitedCity));
            }
        }

        imdCntdCity.addAll(indirectCntdCity);
        return imdCntdCity;
    }

    static int gcdThing(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }
}
