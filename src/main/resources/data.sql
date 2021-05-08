insert into characters (id, name, description, modified, resourceURI, thumbnail)  
values (1,'Hulk', 'verde', current_date, 'teste uri', 'hulk.jpg');

insert into characters (id, name, description, modified, resourceURI, thumbnail)  
values (2,'Iron Man', 'ferro', current_date, 'teste uri', 'iron_man.jpg');

insert into comics(ID, DESCRIPTION, DIAMOND_CODE, DIGITAL_ID, EAN, FORMAT, ISBN, ISSN, ISSUE_NUMBER, MODIFIED, PAGE_COUNT, RESOURCEURI, TEXT_OBJECTS, TITLE, UPC, VARIANT_DESCRIPTION)
values (1, 'Avengers vs. Thanos', 'diamond teste', 100, 'ean teste', 'digital', '978-85-7686-026-6', '1111-2222', 1, current_date, 200, 'uri teste', 'objects test', 'Avengers', 'teste upc', 'outra descrição');

insert into comics(ID, DESCRIPTION, DIAMOND_CODE, DIGITAL_ID, EAN, FORMAT, ISBN, ISSN, ISSUE_NUMBER, MODIFIED, PAGE_COUNT, RESOURCEURI, TEXT_OBJECTS, TITLE, UPC, VARIANT_DESCRIPTION)
values (2, 'Infinity War', 'diamond teste', 100, 'ean teste', 'digital', '978-85-7686-026-7', '1111-2222', 1, current_date, 200, 'uri teste', 'objects test', 'Avengers', 'teste upc', 'outra descrição');

insert into events(ID, DESCRIPTION, MODIFIED, START, END, RESOURCEURI, TITLE)
values(1, 'Teste event 1', current_date, '2021-05-01', '2021-05-05', 'teste uri', 'Teste titulo 1');

insert into events(ID, DESCRIPTION, MODIFIED, START, END, RESOURCEURI, TITLE)
values(2, 'Teste event 2', current_date, '2021-05-01', '2021-05-05', 'teste uri', 'Teste titulo 2');

insert into stories(ID, DESCRIPTION, MODIFIED, RESOURCEURI, TITLE, TYPE)
values(1, 'Teste story 1', current_date, 'teste uri', 'Teste titulo 1', 'teste type 1');

insert into stories(ID, DESCRIPTION, MODIFIED, RESOURCEURI, TITLE, TYPE)
values(2, 'Teste story 2', current_date, 'teste uri', 'Teste titulo 2', 'teste type 2');

insert into series(ID, DESCRIPTION, END_YEAR, MODIFIED, RATING, RESOURCEURI, START_YEAR, TITLE)
values(1,'Avengers', 2021, current_date, 'teste rating', 'teste uri', 2010, 'Avengers');

insert into series(ID, DESCRIPTION, END_YEAR, MODIFIED, RATING, RESOURCEURI, START_YEAR, TITLE)
values(2,'X-men', 2021, current_date, 'teste rating', 'teste uri', 2010, 'X-men');

insert into characters_comics (character_id, comic_id) values (1,1);
insert into characters_comics (character_id, comic_id) values (1,2);
insert into characters_comics (character_id, comic_id) values (2,1);

insert into characters_stories (character_id, stories_id) values (1,1);
insert into characters_stories (character_id, stories_id) values (1,2);
insert into characters_stories (character_id, stories_id) values (2,1);

insert into characters_events (character_id, event_id) values (1,1);
insert into characters_events (character_id, event_id) values (1,2);
insert into characters_events (character_id, event_id) values (2,1);

insert into characters_series (character_id, serie_id) values (1,1);
insert into characters_series (character_id, serie_id) values (1,2);
insert into characters_series (character_id, serie_id) values (2,1);