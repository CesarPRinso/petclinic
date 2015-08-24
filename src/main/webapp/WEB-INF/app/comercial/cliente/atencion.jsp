<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  

<t:wrapper title="Visitas">
    <a href="${pageContext.request.contextPath}/com/atencion/new" class="pull-right btn btn-primary"> Nuevo</a>
    <h1 class="page-header"> Visitas </h1>


    <table class="table table-striped">
        <tr>
            <th class="col-md-8">Mascota</th>
            <th class="col-md-1">Fecha de ingreso</th>
            <th class="col-md-1">Fecha de salida</th>
            <th class="col-md-1">Estado</th>
            <th class="col-md-2">Acciones</th>
        </tr>
        <c:forEach items="${visitas}" var="e"  >
            <tr>
                <td> 
                    ${e.mascota.nombre}  

                    <div class="row text-muted small">
                        <div class="col-md-6">

                            Veterinario : ${e.veterinario.persona.nombres} <br/>
                            Motivo : ${e.motivo}<br/>
                            Diagnostico : ${e.diagnostico}<br/>
                            Tratamiento : ${e.tratamiento}<br>
                            Dieta :  ${e.dieta}<br>                            
                            Proxima Visita : ${e.proximaVisita}
                        </div>
                        <div class="col-md-6">

                        </div>
                    </div>
                </td>
                <td>
                    Fecha de Ingreso: <fmt:formatDate value="${e.fechaIngreso}" pattern="dd/MM/yyyy" /> <br/>
                </td>
                <td>
                    Fecha de Salida: <fmt:formatDate value="${e.fechaSalida}" pattern="dd/MM/yyyy" /> <br/>
                </td>  
                <td>
                    <span class="label label-${e.fechaSalida == null ? 'info': 'danger' }">
                        ${e.fechaSalida == null ? "Tratamiento" :"Finalizado" }
                    </span>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/com/atencion/update/${e.id}">Editar</a> 
                    <a href="${pageContext.request.contextPath}/com/atencion/delete/${e.id}">Eliminar</a>  
                    <a href="${pageContext.request.contextPath}/com/atencion/salida/${e.id}" >Salida</a>

                </td>
            </tr>
        </c:forEach>
    </table>


</t:wrapper>