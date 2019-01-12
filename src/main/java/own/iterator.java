package own;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class iterator {

    public void  iterator1() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("two");
        list.add("two");
        list.add("two");
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals("two")){
                list.remove(i);
            }
        }
        System.out.println(list);
    }

    public void iterator2() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("two");
        list.add("two");
        list.add("two");
        for(String s:list){
            if(s.equals("two")){
                list.remove(s);
            }
        }
        System.out.println(list);
    }

    public void iterator3() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("two");
        list.add("two");
        list.add("two");
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            String s = iter.next();
            if(s.equals("two")){
                iter.remove();
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class clazz = myClassLoader.findClass(" /home/gin/projects/test/target/classes/java/util/UUID");
        try {
            UUID uuid = (UUID)clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        UUID a = UUID.randomUUID();
        iterator itr = new iterator();
        itr.iterator2();
    }
}
