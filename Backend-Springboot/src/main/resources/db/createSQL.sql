DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` integer primary key autoincrement,
  `name` char(25) not null,
  `password` char(16) not null,
  `profile` char(200) not null,
  `root` int not null,
  `sex` int not null
);

DROP TABLE IF EXISTS `blog`;
CREATE TABLE IF NOT EXISTS `blog` (
  `id` integer primary key autoincrement,
  `title` char(50) not null,
  `content` char(400) not null,
  `release_datetime` datetime not null,
  `lastest_upload_datetime` datetime not null,
  `author_id` integer not null,
  foreign key(`author_id`) references user(`id`) on delete cascade on update cascade
);
