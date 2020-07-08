// Задание 4.
// public final class Integer extends Number. В таком случае модуль Number открыт для расширения,
// а модуль Integer - закрыт (объявлен как final). Так делается в виду того, что, с точки зрения семантики,
// модуль Number можно специализировать (как раз модуль Integer это и делаем), а модуль Integer - нет.


// Задание 5.
// В Java, если рассматривать модуль как класс,
// доступны все 5 основных принципов для механизма добавления в проект основного модуля:

//1. Новый модуль может задавать некоторый базовый тип, который потенциально должен допускать
// параметризацию другими типами (обобщённые типы, типы-генерики); - public class A<T>

//2. Новый модуль может объединять несколько функций, которые активно обращаются друг к другу;
// - методы внутри класса

//3. Новый модуль может входить в семейство модулей, ориентированных на решение некоторой общей задачи,
// которую не удаётся решить с помощью одного модуля; - наследование, композиция

//4. Новый модуль может предлагать конкретную реализацию родительского модуля, которая должна выбираться
// динамически (полиморфно) -- например, реализация обобщённого типа для конкретного типа-параметра;
// - ad-hoc полиморфизм

//5. Новый модуль может интегрировать общее поведение нескольких модулей, которые различаются лишь деталями.
// - наследование, композиция


// Задание 6.
// Существуют ли ситуации, когда связи между модулями должны делаться публичными?
// Нет, не существует. Это нарушает инкапсуляцию, принцип SRP, когда один из модулей связан с другим модулем открыто.

// Какие метрики вы бы предложили для количественной оценки принципов организации модулей?
// Кол-во семантических единиц в программе (модулей, отвечающих за что-либо), так называемых "сущностей".

// Если вы разрабатывали программы, в которых было хотя бы 3-5 классов,
// как бы вы оценили их модульность по этим метрикам?
// Все зависит от конкретных случаев. Допустим, у нас есть абстрактный класс Pizza и много-много классов,
// реализующих конкретные виды пицц. Также у нас есть абстрактный класс Coffee и также много-много классов,
// реализующих конкретные виды кофе. Еще у нас есть абстрактный класс Restaurant и также классы,
// реализующие конкретные рестораны, где продается пицца и кофе. Добавим сюда абстрактный класс Courier и классы,
// реализующие конкретные типы доставки. Получаются 3 семантические единицы: еда, заведение, доставка, которые можно
// представить в виде разных модулей.
