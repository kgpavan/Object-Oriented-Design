////package com.nespresso.git.training;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Iterator;
//import java.util.List;
//import java.util.TreeSet;
//
//public class Task implements Comparable<Task> {
//
//    public int compareTo(Task o) {
//        return 0;
//    }
//
//
//    //
////    private String name;
////    private TaskPriority taskPriority;
////    public final Task myTask = new Task(" ", TaskPriority.HIGH) {
////
////        public void method() {
////            System.out.println(name);
////
////        }
////    };
////
////    public Task(String name, TaskPriority taskPriority) {
////        this.name = name;
////        this.taskPriority = taskPriority;
////    }
////
////    public static final Comparator<Task> PRIORITY_COMPARATOR = new Comparator<Task>() {
////
////        @Override
////        public int compare(Task task1, Task task2) {
////            return task1.taskPriority.compareTo(task2.taskPriority);
////        }
////    };
////
////    @Override
////    public boolean equals(Object obj) {
////        if (obj != null && obj instanceof Task) {
////            return ((Task) obj).name.equals(this.name);
////        }
////        return false;
////    };
////
////    @Override
////    public int hashCode() {
////        return this.name.hashCode() * this.taskPriority.hashCode();
////    }
////
////    @Override
////    public String toString() {
////        return this.name + " " + this.taskPriority;
////    }
////
////    public static void main(String[] args) {
////        Task javaTask = new Task("code java", TaskPriority.HIGH);
////        Task htmlTask = new Task("code html", TaskPriority.MEDIUM);
////        Task javascriptTask = new Task("code javascript", TaskPriority.LOW);
////        Task gitTask = new Task("git", TaskPriority.HIGH);
////
////        List<Task> myTasks = new ArrayList<Task>();
////        Collections.addAll(myTasks, javaTask, htmlTask, javascriptTask);
////        List<Task> yourTasks = new ArrayList<Task>();
////        Collections.addAll(yourTasks, javaTask, htmlTask, gitTask);
////
////        getCommonTasks(myTasks, yourTasks);
////
////        getUniqueToMySide(myTasks, yourTasks);
////
////        Collections.sort(yourTasks);
////
////        Iterator<Task> iterator = yourTasks.iterator();
////        //        while(iterator.hasNext()){
////        //            System.out.println(iterator.next());
////        //        }
////
////        TreeSet<Task> taskSet = new TreeSet<Task>(PRIORITY_COMPARATOR);
////        Collections.addAll(taskSet, javaTask, javascriptTask, htmlTask, gitTask);
////        System.out.println(taskSet.size());
////        for (Task task : taskSet) {
////            System.out.println(task);
////        }
////        System.out.println(taskSet.headSet(htmlTask));
////
////    }
////
////    private static void getUniqueToMySide(List<Task> myTasks, List<Task> yourTasks) {
////        ArrayList<Task> uniqueToMySide = new ArrayList<Task>(myTasks);
////        uniqueToMySide.removeAll(yourTasks);
////    }
////
////    private static void getCommonTasks(List<Task> myTasks, List<Task> yourTasks) {
////        ArrayList<Task> commonTasks = new ArrayList<>(myTasks);
////        commonTasks.retainAll(yourTasks);
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
////
////    @Override
////    public int compareTo(Task task) {
////        return this.name.compareTo(task.name);
////    }
//}
