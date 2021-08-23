insert into authorities (authority) values ('ROLE_ADMIN');
insert into authorities (authority) values ('ROLE_USER');

insert into users (username, password, authority_id) values ('admin', '$2a$10$ekUI.Yq6X3jmWy5XPVr9NuU1L.e68QXaah7S6gbVvcafonA/NG.au', 1);
insert into users (username, password, authority_id) values ('user', '$2a$10$qyvu7GAiKk6eO7TnX0fZ4OLm5/Lfc5Xe/rxVpUXW/PGzFwmAhGtXC', 2);

insert into post (name, user_id) values ('О чем этот форум?', 1);
insert into post (name, user_id) values ('Правила форума.', 1);