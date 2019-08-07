insert into BOARD (id,title, content, create_date)
values(1,'goodday', 'goodbye',CURRENT_TIMESTAMP);

insert into BOARD (id,title, content, create_date)
values(2,'hoodday', 'hoodby' ,CURRENT_TIMESTAMP);

insert into comment (content, board_id)
values ('good',1 );
--
insert into comment (content,board_id)
values ('hood',1);