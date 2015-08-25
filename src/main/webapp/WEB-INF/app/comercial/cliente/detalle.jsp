<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:wrapper title="Detalle Vacunas">
    <h1 class="page-header"> Vacunas </h1>

    <form action="${pageContext.request.contextPath}/com/detalle/save" method="post" class="form-inline">

        <input type="hidden" name="id" value="${vacuna.id}"/>

        <div class="form-group">
            <label class="control-label"> Vacunas </label>

            <select name="vacuna.id" class="form-control" ${vacuna.id !=  null ? 'disabled' : ""}> 
                <c:forEach items="${vacunas}" var="e" >
                    <option value="${e.id}"  ${detalle.vacuna.id == e.id ? 'selected': '' }> ${e.nombre} </option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label class="control-label"> Mascota </label>

            <select name="mascota.id" class="form-control" id="especie">
                <c:forEach items="${mascotas}" var="e" >
                    <option value="${e.id}"  ${vacuna.mascota.id == e.id ? 'selected': '' }> ${e.nombre} </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label class="control-label"> Fecha de proxima Vacuna </label>
            <input type="date" class="form-control" name="proximavacuna" value="${detalle.proximavacuna}" required="">
        </div>

        <div class="form-group text-center">
            <button type="submit" class="btn btn-primary">Guardar</button>
            <a href="${pageContext.request.contextPath}/com/detalle" class="btn btn-link">Cancelar</a>
        </div>
    </form>


    <br/>
    <table class="table table-striped">
        <tr>
            <th class="col-md-5">Mascota</th>            
            <th class="col-md-5">Vacuna</th>
            <th class="col-md-5">Proxima Vacuna</th>
            <th class="col-md-2">Acciones</th>
        </tr>
        <c:forEach items="${detalles}" var="e"  >
            <tr>
                <td> ${e.mascota.nombre}</td>
                <td> ${e.vacuna.nombre}</td>
                <td> ${e.proximavacuna} </td>  
                <td>
                    <a href="${pageContext.request.contextPath}/com/detalle/update/${e.id}">Editar</a> 
                    <a href="${pageContext.request.contextPath}/com/detalle/delete/${e.id}">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
    </table>



</t:wrapper>



