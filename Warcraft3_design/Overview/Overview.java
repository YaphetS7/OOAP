/*
Наиболее общие сущности системы Warcraft 3 (WC3):

Player - игрок. Тут все понятно. Что делает:
- Управляет юнитами, героями

Build - здание. Общая сущность, в которую входит множество типов зданий. Бывают союзными, вражескими и нейтральными.
Что делает:
- Производит новые сущности(юнитов) или позволяет приобретать артефакты или добывать ресурсы (шахта с золотом)

Hero - герой. Общая сущность, в которую входят герои разных рас и другие. Что делает:
- Атакует(будучи подвластным игроку)
- Применяет умения
- Перемещается по карте(будучи подвластным игроку)

Unit - юнит. Бывают подконтрольными и неподконтрольными, бывают союзными, вражескими и нейтральными.
За убийство - начисляют опыт и деньги, в зависимости от ряда условий.Что делает:
- Атакует (будучи подвластным игроку или нет - зависит от типа юнита)
- Применяет умения (при наличии)
- Перемещается по карте (будучи подвластным игроку или нет - зависит от типа юнита)

Item - артефакты, которые можно вкладывать в героев. Увеличивают или уменьшают те или иные характеристики.
Могут приобретаться в лавках или выбиваться с нейтральных юнитов. Что делают:
- Увеличивают/уменьшают характеристики
- Позволяют использовать некоторые активные умения, которые доступны только владельцу какого-то конкретного артефакта.

Location - локация, карта, на которой происходит основная механика.
Хотим часто добавлять и обновлять уже существующие карты!!!. Что делает:
- Содержит в себе все остальные сущности.

Resource - ресурсы. Золото/дерево, может быть что-то еще - зависит от локации. Что делают:
- Добываются и расходуются игроком

DecorItem - декорации на локации, которые не влияют на механику игру. Что делает:
- Влияет на визуальную составляющую игры (отрисовка, анимации, модели и т.п.)





 */