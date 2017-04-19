package com.coffeemath.totalwararmymanager.Models;

/**
 * Created by John Michael on 4/17/2017.
 */
public class Test {
    public static void main(String[] args){
//       Players myPlayer = new Players();
       Leader myLeader = new Leader("nadskun", 0, 0, 1,1);

       System.out.println(myLeader.getName());
       System.out.println(myLeader.getLeader_id());
       System.out.println(myLeader.getTerrain_type());
       System.out.println(myLeader.getRecruitment_discount());
       System.out.println(myLeader.getUpkeep_discount());
    }

}
