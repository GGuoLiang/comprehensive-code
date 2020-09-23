package com.gguoliang.designPattern.abstractFactory.example1;

/**
 * @Author GGuoLiang
 * @Date 2020/9/15 7:19 上午
 * @Version 1.0
 */
public class CarType {

    private Car car;

    public Car getCar(String carType){
        if(carType.equals("BenQ")){
            car = new BenQ();
        }else if (carType.equals("BMW")){
            car = new BMW();
        }else if (carType.equals("GeneralMotors")){
            car = new GeneralMotors();
        }
        return car;
    }


    public static void main(String[] args) {
        CarType carType = new CarType();
        Car benQ = carType.getCar("BenQ");
        System.out.println(benQ.getBody());
        System.out.println(benQ.getEngine());
        System.out.println(benQ.getMirrors());
        System.out.println(benQ.getWheels());

    }
}
