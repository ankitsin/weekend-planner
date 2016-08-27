insert into user (user_id,email_id,name,mobile,token_id) values (1,'vikas.bhoria@practo.com','Vikas Bhoria','8960032462',null);
insert into destination (destination_id,location,type,distance) values(1,'Muthyala Maduvu','Waterfall',43);
insert into trip (trip_id,trip_name,user_id,going_date,destination_id,going_people,space_left,num_of_day,average_cost,created_at,modified_at,is_deleted) values (1,'Trip to Muthyala Maduvu',1,now(),1,3,20,3,5000,now(),now(),0);
insert into signedup (id,signup_user,signed_trip) values(1,1,1);