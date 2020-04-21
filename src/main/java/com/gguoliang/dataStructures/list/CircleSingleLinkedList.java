package com.gguoliang.dataStructures.list;


import com.gguoliang.entity.Boy;

/**
 * @Author GGuoLiang
 * @Date 2020/4/21 12:04 上午
 * @Version 1.0
 *
 * 单向环形链表
 */
public class CircleSingleLinkedList {

    private Boy first = null;


    public void add(int nums){
        if(nums < 1){
            return;
        }
        Boy temp = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                first.setNext(boy);
                temp = first;
            }else{
                temp.setNext(boy);
                boy.setNext(first);
                temp = boy;
            }
        }
    }

    public void show(){
        if (first == null) {
            System.out.println("没有任何小孩~~");
            return; }
        Boy temp = first;
        while (true){
            System.out.println("排队顺序"+temp.getNo());
            if(temp.getNext() == first){
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     *  出圈方法
     * @param startNo
     * @param countNum
     * @param nums
     *
     *  辅助指正helper 通过遍历 helper指向节点的最后一位
     *  startNo
     *  移动startNo-1
     *  first指针指向第一个数的位置
     *  helper指针指向第一个数的前节点
     *
     *  countNum
     *  移动 countNum - 1
     *  first指针指向应该出圈的节点
     *  helper指针指向出圈节点的前一个节点
     *  出圈操作
     *  first = first.getNext();
     *  helper.setNext(first);
     *
     *
     *
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        // 创建要给辅助指针,帮助完成小孩出圈
        Boy helper = first;
        // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
        while (true) {
            // 说明 helper 指向最后小孩节点
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让 first 和 helper 移动 k - 1 次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让 first 和 helper 指针同时 的移动
        // 这里是一个循环操作，知道圈中只有一个节点
        while (true) {
            //说明圈中只有一个节点
            if (helper == first) {
                break;
            }
            //让 first 和 helper 指针同时 的移动 countNum - 1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时 first 指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d 出圈\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());
    }

}



