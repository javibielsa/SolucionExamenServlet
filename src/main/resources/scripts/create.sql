create table IF NOT EXISTS COMPANIES(
	name varchar(25) PRIMARY KEY,
	creationDate date
);
create table IF NOT EXISTS CONSOLES(
	name varchar(25) PRIMARY KEY,
	companyName varchar(25)
);
create table IF NOT EXISTS VIDEOGAMES(
	title varchar(25) PRIMARY KEY,
	recommendedAge varchar(25),
	releaseDate date,
	consoleName varchar(25)
);