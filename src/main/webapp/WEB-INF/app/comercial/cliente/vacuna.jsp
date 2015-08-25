<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:wrapper title="Vacunas">
    <h1 class="page-header"> vacunas </h1>
    
    <form action="${pageContext.request.contextPath}/com/vacuna/save" method="post" class="form-inline">
        <input type="hidden" name="id" value="${vacuna.id}"/>

        <div class="form-group">
            <input type="text" class="form-control" placeholder="nombre" name="nombre" value="${vacuna.nombre}" required="">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="decripcion" name="decripcion" value="${vacuna.descripcion}" required="">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="precio" name="precio" value="${vacuna.precio}" required="">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="edad" name="edad" value="${vacuna.edad}" required="">
        </div>

        <button type="submit" class="btn btn-primary">Guardar</button>
        <a href="${pageContext.request.contextPath}/com/vacuna" class="btn btn-link">Cancelar</a>
    </form>

    <br/>
    <table class="table table-striped">
        <tr>
            <th class="col-md-5">Nombre</th>
            <th class="col-md-3">Descripcion</th>
            <th class="col-md-3">Precio</th>
            <th class="col-md-12">Para mascotas de edad</th>
            <th class="col-md-2">Acciones</th>
        </tr>
        <c:forEach items="${vacunas}" var="e"  >
            <tr>
                <td> ${e.nombre}</td>
                <td> ${e.decripcion}</td>
                <td> ${e.precio}</td>
                <td> ${e.edad}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/com/vacuna/update/${e.id}">Editar</a> 
                    <a href="${pageContext.request.contextPath}/com/vacuna/delete/${e.id}">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
    </table>


</t:wrapper>