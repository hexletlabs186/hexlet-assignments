package exercise;

import lombok.SneakyThrows;

class App {

    @SneakyThrows
    public static void main(String[] args) {
        // BEGIN
// Создаём лист
        SafetyList list = new SafetyList();

        Thread thread = new Thread(new ListThread(list));
        thread.start();

        Thread thread2 = new Thread(new ListThread(list));
        thread2.start();

        thread.join();
        thread2.join();

// Поток добавил в лист 1000 элементов
        System.out.println(list.getSize());
         // 1000
        
        // END
    }
}

