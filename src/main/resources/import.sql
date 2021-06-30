insert into PLACES (placeId, city, country) values (places_seq.nextval, 'London', 'United Kingdom');
insert into PLACES (placeId, city, country) values (places_seq.nextval, 'Paris', 'France');
insert into PLACES (placeId, city, country) values (places_seq.nextval, 'New York', 'USA');
insert into PLACES (placeId, city, country) values (places_seq.nextval, 'Tokyo', 'Japan');
insert into PLACES (placeId, city, country) values (places_seq.nextval, 'Sydney', 'Australia');
insert into PLACES (placeId, city, country) values (places_seq.nextval, 'Moscow', 'Rusia');

insert into COMPANIES (companyId, name, placeId) values (companies_seq.nextval, 'British Airways', 1);
insert into COMPANIES (companyId, name, placeId) values (companies_seq.nextval, 'The New York Times', 3);
insert into COMPANIES (companyId, name, placeId) values (companies_seq.nextval, 'Toyota', 3);
insert into COMPANIES (companyId, name, placeId) values (companies_seq.nextval, 'BNP Paribas', 2);
insert into COMPANIES (companyId, name, placeId) values (companies_seq.nextval, 'EDF', 2);
insert into COMPANIES (companyId, name, placeId) values (companies_seq.nextval, 'Tesco', 1);
insert into COMPANIES (companyId, name, placeId) values (companies_seq.nextval, 'IBM', 1);
insert into COMPANIES (companyId, name, placeId) values (companies_seq.nextval, 'Google', 3);
insert into COMPANIES (companyId, name, placeId) values (companies_seq.nextval, 'Castlemaine', 5);

insert into CURRENCIES (currencyId, symbol, name) values (currencies_seq.nextval, '$', 'Dollar');
insert into CURRENCIES (currencyId, symbol, name) values (currencies_seq.nextval, '€', 'Euro');
insert into CURRENCIES (currencyId, symbol, name) values (currencies_seq.nextval, '£', 'British Pound');
insert into CURRENCIES (currencyId, symbol, name) values (currencies_seq.nextval, 'p', 'British Pence');
insert into CURRENCIES (currencyId, symbol, name) values (currencies_seq.nextval, '¥', 'Yen');

insert into SHARES (shareId, companyId, currencyId) values (shares_seq.nextval, 8, 1);
insert into SHARES (shareId, companyId, currencyId) values (shares_seq.nextval, 1, 4);
insert into SHARES (shareId, companyId, currencyId) values (shares_seq.nextval, 2, 1);
insert into SHARES (shareId, companyId, currencyId) values (shares_seq.nextval, 3, 1);
insert into SHARES (shareId, companyId, currencyId) values (shares_seq.nextval, 4, 2);
insert into SHARES (shareId, companyId, currencyId) values (shares_seq.nextval, 5, 2);
insert into SHARES (shareId, companyId, currencyId) values (shares_seq.nextval, 6, 4);
insert into SHARES (shareId, companyId, currencyId) values (shares_seq.nextval, 7, 1);













