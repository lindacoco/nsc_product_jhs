use ncs_product;

select * from sale;

select product_code, product_name from product;
select product_code from product;
select product_name from product where product_code ='A001';

insert into product values('A001','아메리카노'),('A002','카푸치노');


insert into sale (no,product_code,price,sale_cnt,margin_rate) values(null,'A002',3800,140,15);