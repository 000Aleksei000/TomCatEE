<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 3/12/2021
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Qualifier</title>
</head>
<body>
<h3>
    If we have indeterminacy need use Qualifier </h3>
    @Qualifier <br>
    @Retention(RetentionPolicy.RUNTIME)<br>
    @Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})<br>
    @interface StudentAnnotation{}<br><br>
    and mark class which we want use <br><br>
    @StudentAnnotation<br>
    class Student implements Person{<br>
    private String name;<br><br>

    public String getName() {<br>
    return "Student";<br>
    }<br><br>

    public void setName(String name) {<br>
    this.name = name;<br>
    }<br>
    }<br>

    and mark Inject indeterminacy<br><br>
    @Inject<br>
    @StudentAnnotation<br>
    Person person;<br> <br>

@Inject<br>
@WorkerAnnotation<br>
Person worker;<br><br>

@Qualifier<br>
@Retention(RetentionPolicy.RUNTIME)<br>
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})<br>
@interface WorkerAnnotation{}<br>

@WorkerAnnotation<br>
class Worker implements Person{<br>
private String name;<br><br>

@Override<br>
public String getName() {<br>
return "Worker";<br>
}<br><br>

@Override<br>
public void setName(String s) {<br>
this.name = s;<br>
}<br>
}


</body>
</html>
