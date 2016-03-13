CREATE DATABASE IF NOT EXISTS HMS;
USE HMS;

insert into users (FirstName, LastName, AddressLine1, AddressLine2, City, State, PostalCode, Type, Status, Username, Password) 
values ('rrr', 'lll', 'adr1', 'adr2', 'city', 'state', '09876', '0', '0', 'rrr', 'rrr');

insert into users (FirstName, LastName, AddressLine1, AddressLine2, City, State, PostalCode, Type, Status, Username, Password) 
values ('sss', 'lss', 'adr1', 'adr2', 'city', 'state', '09876', '0', '0', 'sss', 'sss');

insert into creditcards (CardholderName, CreditCardNumber, Balance, CardNickname, UserId, CVV) 
values ('rrr', '1111111111', 20.0, 'rrrCard', 1, 'rrr');

insert into creditcards (CardholderName, CreditCardNumber, Balance, CardNickname, UserId, CVV) 
values ('sss', '22222222', 200.0, 'sssCard', 2, 'sss');

insert into creditcards (CardholderName, CreditCardNumber, Balance, CardNickname, UserId, CVV) 
values ('sss', '33333333', 200.0, 'sssCard2', 2, 'sss');
