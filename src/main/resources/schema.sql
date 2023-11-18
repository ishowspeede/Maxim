create table players (
                         player_id int auto_increment primary key,
                         name varchar(255) not null,
                         age int not null,
                         role varchar(255) not null
);
create table teams (
                       team_id int auto_increment primary key,
                       name varchar(255) not null,
                       number_of_players int not null,
                       country varchar(255) not null
);
create table games(
                      game_id int auto_increment primary key,
                      name varchar(255) not null,
                      pick_online int not null,
                      type_of_game varchar(255) not null
);
create table tournaments(
                            tournament_id int auto_increment primary key,
                            name varchar(255) not null,
                            in_which_game varchar(255) not null,
                            money_win int not null
);