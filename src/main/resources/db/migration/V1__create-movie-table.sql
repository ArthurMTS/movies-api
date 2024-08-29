CREATE TABLE movies(
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    title TEXT NOT NULL,
    description TEXT NOT NULL,
    "year" INT NOT NULL,
    rating FLOAT NOT NULL,
    image TEXT
);