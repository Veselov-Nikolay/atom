#HSLIDE
# Java
lecture 2
## Basics

#HSLIDE
## Отметьтесь на портале
https://atom.mail.ru/

#HSLIDE
### About me
    <span>
        <img src="https://avatars2.githubusercontent.com/u/710546?v=3&s=460" alt="me" style="width: 220px; float: left;"/>
    </span>
    
    <span style="margin-left:10px>
     yan.brikl@gmail.com 
     
     [https://github.com/rybalkinsd](https://github.com/rybalkinsd)
       
     Java 5+ years
     
     Yandex, Allods Team (mail.ru group)
     
     Currently Senior Software Engineer at AliExpress.com
     
    </span>

**Люблю зеленые билды**  

#HSLIDE
### Agenda
1. Classes and objects
1. Inheritance
1. Interfaces
1. Homework 2  

#HSLIDE
### Classes and objects 
1. **[Classes and objects]**  
1. Inheritance
1. Interfaces
1. Homework 2

#HSLIDE 
### Flashback

- Java is **object-oriented**, **class-based**
- Java has static strong typization 

#HSLIDE
### Static strong typization

- Static == compile time
    + \+ fast runtime
    + \+ errors in compile time
    - \- more time on prototyping
- strong typization - *no strict definition*, example:
    ```java
    long num = 42; // <-- legal
    int mindTheGap = 42L; // <-- compilation error
    ```
 
#HSLIDE
### Object oriented
- Everything is an object*
- No code outside object

#HSLIDE
### `class` Definition
```java
class Player {
    private int id;
    private String name;
}
``` 

#HSLIDE
### Instantiation
```java
Player myPlayer = new Player();
```

#HSLIDE
###Constructor
```java
class Player {
    private int id;
    private String name;
    
    public Player(int paramId, String paramName) {
        id = paramId;
        name = paramName;
    }
}
```

Looks shitty

#HSLIDE

### `this` keyword
```java
class Player {
    private int id;
    private String name;
    
    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
```
[Read more about `this`](https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html)

#HSLIDE
###OK, now we have a constructor
 
`Player(int id, String name)`

```java
Player simplePlayer = new Player();
Player customPlayer = new Player(10, "Niels Bohr");
```

#### Looks good?

#HSLIDE
### Of cause *NO*
### Default constructor
The default constructor is a no-argument constructor automatically generated unless you define any constructor in class.

[Read more in official docs](https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html)

[Read more on Stackoverflow](http://stackoverflow.com/questions/4488716/java-default-constructor)


#HSLIDE
### Classes and objects 
1. Classes and objects  
1. **[Inheritance]**
1. Interfaces
1. Homework 2

#HSLIDE
### Inheritance
#### Is-a relation

```java
class Message { 
    private String content;
}

class TitledMessage extends Message {
    private String title;
}
```

**`Titled message` is a `Message`**

#HSLIDE
### `instanceof` operator, miss me?

```java
assertTrue(message instanceof Message); <-- OK
assertThat(message, is(instanceOf(Message.class))); <-- OK
```

### `instanceof` **is not** slow	


#HSLIDE
### `Object` class
Everything is instance of object.

```java
// Informally
class Message extends Object { 
}
```

#HSLIDE
### Constructors and inheritance

I want:
```java
TitlesMessage message = new TitledMessage(title, content);
```

#HSLIDE
### Constructors and inheritance

```java
class Message {
    private String content;
    
    public Message(String content) {
        this.content = content;
    }
}
```

#HSLIDE
### Constructors and inheritance

```java
class TitledMessage extends Message {
    private String title;
    
    public TitledMessage(String title, String content) {
        // hmmmm
    }
}

class Message {
    private String content;
    
    public Message(String content) {
        this.content = content;
    }
}
```

#HSLIDE
### super

```java
class TitledMessage extends Message {
    private String title;
    
    public TitledMessage(String title, String content) {
       super(content);
       this.title = title;
    }
}

class Message {
    private String content;
    
    public Message(String content) {
        this.content = content;
    }
}
```

#HSLIDE
### Methods
```java
class Message {
    private String content;

    public String getContent();
    
    public Message(String content) {
        this.content = content;
    }
}
```

#HSLIDE
### Methods, overloading

Lets add some "pagination"
```java

class Message {
    private static final int CHARS_PER_PAGE = 256;
    private String content;
    
    private String getContent() {
        return content;
    }
    
    private String getContent(int pageNum) {
        if (pageNum < 0) {
            throw new IllegalArgumentException("Page number should be >= 0, got " + pageNum);
        }
            
        return content.substring(pageNum * CHARS_PER_PAGE, (pageNum + 1) * CHARS_PER_PAGE);
    }
    // ...
}
```

#HSLIDE
### Methods, polymorphism
```java

class TitledMessage extends Message {
    private String title;
    
    @Override
    public String getContent() {
        return "Title: " + this.title + ".\n" + getContent();
        
    }

    
    public TitledMessage(String title, String content) {
        // hmmmm
    }
}
```

#HSLIDE
### Override definition

Instance method in a subclass with the *same signature* (name, plus the number and the type of its parameters) 
and *return type* as an instance method in the superclass *overrides* the superclass's method.

[Read more in official docs](https://docs.oracle.com/javase/tutorial/java/IandI/override.html)
**Note:** @Override is *just an annotation to declare* your intentions to override method 


```java
Message message = new Message("my content");
message.getContent();

assertThat(message.getContent(), is(equalTo("my content")));
```

#HSLIDE 
# 6. Homework 1 
1. Course structure  
2. Language architecture  
3. Basic syntax  
4. Git  
5. Gradle  
6. **[Homework 1]**  

#HSLIDE
# Homework 1
1. Fix tests in branch **homework1** and push it to **your fork**  
[[Github branch]](https://github.com/rybalkinsd/atom/tree/homework1)
[[Travis build]](https://travis-ci.org/rybalkinsd/atom/builds/204177834)
2. Make pull request to **course repository**
[https://github.com/rybalkinsd/atom](https://github.com/rybalkinsd/atom)
3. Make sure **tests** and **checkstyle** are passing in **Travis**  

**Deadline:** 1 March  
**Mark:** 5 points

#HSLIDE
## Литература
**Thinking in Java** (в русском переводе - философия Java)  
[https://www.amazon.com/Thinking-Java-4th-Bruce-Eckel/dp/0131872486](https://www.amazon.com/Thinking-Java-4th-Bruce-Eckel/dp/0131872486)  
  
Хорошая книга, придерживаться ее мы, конечно, не будем

#HSLIDE
## IDE
**Intellij IDEA**  
[https://www.jetbrains.com/idea/](https://www.jetbrains.com/idea/)  
  
**Community edition** будет достаточно, но для студентов часто бесплатно предоставляют **professional edition**

#HSLIDE
**Оставьте обратную связь**
(вам на почту придет анкета)  

**Это важно!**
