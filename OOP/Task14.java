// Задание 23.

// Пример абстрагирования:
// Скажем, у нас есть маленький магазинчик. И продаем мы там :) ноутбуки. В информационной системе у нас все просто.
// Один класс - "ноутбук". Дела у нас пошли хорошо, завезли еще техники. Ну и очевидным решением теперь является
// создание родительского класса для класса "ноутбук". Это может быть, например, класс "товар".

// Пример факторизации:
// Есть классы: Bitcoin, USD, USDT. Ну, на первый взгляд кажется, что USDT и Bitcoin - это криптовалюта, ок.
// А что делать с USD? Ну на самом-то деле это все - одно и то же. Это некая валюта.
// => можно все эти классы унаследовать от одного.