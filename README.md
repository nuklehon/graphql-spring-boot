#Example

```
mutation createAuthor {
   createAuthor(name: "Jean") {
    id
    name
  }
}

mutation createMovie1 {
  createMovie(title: "Jean - Movie 1", authorId: 1) {
    id
    title
  }
}

mutation createMovie2 {
  createMovie(title: "Jean - Movie 2", authorId: 1) {
    id
    title
  }
}

mutation createMovie3 {
  createMovie(title: "Jean - Movie 3", authorId: 1) {
    id
    title
  }
}

query Query {
  authors {
    id
    name
    movies {
      title
    }
  }
}

query QueryJean {
  authors(id: 1) {
    id
    name
    movies {
      title
    }
  }
}

```