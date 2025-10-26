CREATE DATABASE Movieinfo;
USE Movieinfo;

#Create “MovieInfo” database and Create the “movie” table by using SQL statement
# Schema: Movies (title:string, year:integer, length:integer, genre:string, rating: double)
CREATE TABLE movie(  #Movies (title:string, year:integer, length:integer, genre:string, rating: double)
	title varchar(40),
    year int,
    length int,
    genre varchar(40),
    rating double
);
#2. Add one attribute “movieid” as string into the “movie” table then set it as primary key
ALTER TABLE movie ADD movieid char(3);
ALTER TABLE movie ADD CONSTRAINT movieid_pk PRIMARY KEY (movieid);
#ALTER TABLE movie ADD PRIMARY KEY (movieid);


#Insert data to movie table
#Chocolate Factory 2006 112 drama 3.5
#Star Wars 1977 124 scifi 4
#Wizard of Oz 1970 100 advanture 3

INSERT INTO movie VALUES ("Chocolate Factory", 2006, 112, "drama", 3.5, "m01");
INSERT INTO movie VALUES ("Star Wars", 1977, 124, "scifi", 4, "m02");
INSERT INTO movie VALUES ("Wizard of Oz", 1970, 100, "adventure", 3, "m03");

#starid name address gender movieid
#s01 Wookiee Hollywood North st. M m02

CREATE TABLE moviestar (
	starid int,
	name varchar(40),
    address varchar(60),
    gender char(1),
    movieid char(3),
    
	PRIMARY KEY (starid),
    FOREIGN KEY (movieid) REFERENCES movie(movieid) 
)


#▪ Find who played in Star Wars
Select name From movie join moviestar on movie.movieid=moviestar.movieid where movie.title = "Star Wars";
#▪ Find which movie that Willy Wongka played
Select title From movie join moviestar on movie.movieid=moviestar.movieid where moviestar.name = "Willy Wonka";
#▪ Find the moviestar’s name beginning with “W”
Select name From moviestar where name like "W%";
#▪ Count the number of actors and the number of actresses from “moviestar” table
Select gender, count(*) as gender_no From moviestar group by gender;
#▪ Find the movie that is older than year 2000 and played by Dorothy
Select title From movie join moviestar on movie.movieid=moviestar.movieid where movie.year<2000 AND moviestar.name = "Dorothy";
#▪ Show the length difference of “Chocolate Factory-Wizard of Oz” and “Star Wars – Wizard of Oz”
Select title, abs(length-(select length from movie where title="Wizard of Oz")) from movie where title <> "Wizard of Oz";
#▪ Find who played in the movies that the rating ≧ 3.5
Select ms.name From movies as m join moviestar as ms on m.movieid=ms.movieid where rating > 3.5;
#▪ Find the movie that played by an actress
Select distinct title from movie as m join moviestar as ms on m.movieid=ms.movieid where ms.gender="f";
#▪ Count the number of actors and actresses for each movie
Select title, gender, count(*) as no_act_actres from movie as m join moviestar as ms on m.movieid=ms.movieid
group by m.title, gender;




	