package com.learn.object;

/**
 * 2.完成课堂上没有讲完的案例
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/22
 */
public class Demo02 {
    public static void main(String[] args) {
        FootballCoach footballCoach = new FootballCoach("足球教练", 20, 50000, 5000);
        System.out.println(footballCoach.name + "的奖金是：" + footballCoach.bonus);
        footballCoach.teach();
        footballCoach.eat();
        footballCoach.sleep();
        System.out.println("---------------------");

        TableTennisPlayer tableTennisPlayer = new TableTennisPlayer();
        tableTennisPlayer.learn();
        tableTennisPlayer.match();
        tableTennisPlayer.train();
    }
}

// 体育从业人员都有的属性
class Human {
    String name;
    int age;
    int salary;

    public void eat() {
        System.out.println("体育从业人员都要吃饭");
    }

    public void sleep() {
        System.out.println("体育从业人员都要睡觉");
    }
}

// 定义运动员，继承父类Human的特征
abstract class Athlete extends Human {
    public Athlete() {
    }

    public Athlete(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // 运动员特有的训练行为
    public abstract void train();

    // 运动员的比赛行为
    public abstract void match();

}

// 定义教练，继承父类Human的特征
abstract class Coach extends Human {
    // 教练特有的奖金属性
    int bonus;

    public Coach() {
    }

    public Coach(String name, int age, int salary, int bonus) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.bonus = bonus;
    }

    // 教练特有的教学行为
    public abstract void teach();
}

// 学英语是个扩展功能，单独写在每个具体实现类里面很麻烦
// 提取出来形成类，类又无法完成形式上的多继承，将其定义为接口
interface LearnEnglish {
    void learn();
}

// 定义足球运动员
class FootballPlayer extends Athlete {
    public FootballPlayer() {
    }

    public FootballPlayer(String name, int age, int salary) {
        super(name, age, salary);
    }

    @Override
    public void train() {
        System.out.println("足球运动员训练");
    }

    @Override
    public void match() {
        System.out.println("足球运动员比赛");
    }
}

// 定义足球教练
class FootballCoach extends Coach {
    public FootballCoach() {
    }
    public FootballCoach(String name, int age, int salary, int bonus) {
        super(name, age, salary, bonus);
    }

    @Override
    public void teach() {
        System.out.println("足球教练教学");
    }
}

// 定义乒乓球运动员
class TableTennisPlayer extends Athlete implements LearnEnglish {
    public TableTennisPlayer() {
    }

    public TableTennisPlayer(String name, int age, int salary) {
        super(name, age, salary);
    }

    @Override
    public void train() {
        System.out.println("乒乓球运动员训练");
    }

    @Override
    public void match() {
        System.out.println("乒乓球运动员比赛");
    }

    @Override
    public void learn() {
        System.out.println("乒乓球运动员学英语");
    }
}

// 定义乒乓球教练类
class TableTennisCoach extends Coach implements LearnEnglish {
    public TableTennisCoach() {
    }

    public TableTennisCoach(String name, int age, int salary, int bonus) {
        super(name, age, salary, bonus);
    }

    @Override
    public void teach() {
        System.out.println("乒乓球教练教学");
    }

    @Override
    public void learn() {
        System.out.println("乒乓球教练学英语");
    }
}