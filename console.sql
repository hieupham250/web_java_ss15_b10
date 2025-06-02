create database bai10;

use bai10;

create table Resume
(
    id           bigint primary key auto_increment,
    full_name    varchar(255),
    email        varchar(255),
    phone_number varchar(15),
    education    varchar(255),
    experience   varchar(255),
    skills       text
);

delimiter //
create procedure find_all_resume()
begin
    select * from Resume;
end;

create procedure find_resume_by_id(
    id_in int
)
begin
    select * from Resume where id = id_in;
end;

create procedure create_resume(
    full_name_in varchar(255),
    email_in varchar(255),
    phone_number_in varchar(15),
    education_in varchar(255),
    experience_in varchar(255),
    skills_in text
)
begin
    insert into Resume(full_name, email, phone_number, education, experience, skills)
    values (full_name_in, email_in, phone_number_in, education_in, experience_in, skills_in);
end;

create procedure update_resume(
    id_in bigint,
    full_name_in varchar(255),
    email_in varchar(255),
    phone_number_in varchar(15),
    education_in varchar(255),
    experience_in varchar(255),
    skills_in text
)
begin
    update Resume
    set full_name    = full_name_in,
        email        = email_in,
        phone_number = phone_number_in,
        education    = education_in,
        experience   = experience_in,
        skills       = skills_in
    where id = id_in;
end;

create procedure delete_resume(
    id_in bigint
)
begin
    delete from Resume where id = id_in;
end;
delimiter //