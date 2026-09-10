package br.pucrs.leonardo.ramos002.springboot_excercise.controllers;
import br.pucrs.leonardo.ramos002.springboot_excercise.Books;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BooksController {

    public ArrayList<Books> books = new ArrayList<Books>(
        java.util.Arrays.asList(
            new Books() {{
                setId(1);
                setTitle("The Case for Catholicism");
                setAuthor("Trent Horn");
                setYear(2017);
            }},
            new Books() {{
                setId(2);
                setTitle("Summa Theologica");
                setAuthor("Thomas Aquinas");
                setYear(1270);
            }},
            new Books() {{
                setId(3);
                setTitle("Theology of the Body");
                setAuthor("John Paul II");
                setYear(1994);
            }}
        )
    );

    @GetMapping("/")
    public String getMensagemInicial() {
        return "Aplicacao Spring-Boot funcionando!";
    }

    @GetMapping("/livros")
    public ArrayList<Books> getBooks() {
        return books;
    }

    @GetMapping("/livros/titulos")
    public ArrayList<String> getBooksTitles() {
        ArrayList<String> titles = new ArrayList<String>();
        books.forEach(book -> titles.add(book.getTitle()));
        return titles;
    }

    @GetMapping("/livros/autores")
    public ArrayList<String> getBooksAuthors() {
        ArrayList<String> authors = new ArrayList<String>();
        books.forEach(book -> authors.add(book.getAuthor()));
        return authors;
    }
}