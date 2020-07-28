package com.hjt.utils;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    static List<Student> studentList;
    static {
        studentList = new ArrayList<>();
       for (int i=0;i<100;i++){
           Student student = new Student(i+"","胡江涛"+i+"号","男",Math.floor(Math.random()*10)+"",i+0.0);
           studentList.add(student);
       }
    }
    public static void main(String[] args) {
        List<Response> list = new ArrayList<>();
        studentList.forEach(
                student -> {
                    if (checkList(list,student.getClasses())){
                        list.add(new Response(student.getClasses(),0.0,0));
                    }
                }
        );
        System.out.println(list.toString());
        studentList.forEach(
                student -> {
                    list.forEach(
                            response->{
                                if (student.getClasses().equals(response.getClasses()))
                                {
                                    response.setCount(response.getCount()+student.getMoney());
                                    response.setNum(response.getNum()+1);
                                }
                            }
                    );
                }
        );
        System.out.println(list.toString());
    }



    public static Boolean checkList(List<Response> arrayList,String str){
        List<Response> stringStream = arrayList.stream().filter(
                response -> str.equals(response.getClasses())
        ).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(stringStream))
        {
            return true;
        }
        return false;
    }
}
