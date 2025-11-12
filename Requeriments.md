# Requerimientos para una Aplicación de Gestión de Proyectos de Software

## Requerimientos Funcionales

*Gestión de Proyectos*
La aplicación debe permitir crear, editar, eliminar y visualizar proyectos. 
Cada proyecto requiere información como nombre, descripción, fecha de inicio 
y fin, estado (activo, pausado, completado), y presupuesto asignado. Debe permitir
asignar miembros al equipo y definir roles.

*Gestión de Tareas/Actividades*
Los usuarios deben poder crear tareas dentro de cada proyecto, 
asignarlas a miembros del equipo, establecer prioridades (alta, media, baja),
definir fechas de vencimiento y estados (pendiente, en progreso, completada, bloqueada). 
Las tareas deben poder tener subtareas y dependencias entre ellas.

*Seguimiento de Tiempo*
La aplicación debe registrar el tiempo dedicado a cada tarea, permitir reportes de horas
trabajadas y comparar con las estimaciones. Debe generar reportes de productividad por 
miembro del equipo.

*Documentación y Recursos*
Debe permitir adjuntar archivos, compartir documentos y mantener un repositorio de recursos 
del proyecto. Facilitar colaboración mediante comentarios y anotaciones.

*Reportes y Análisis*
Generar reportes de progreso, gráficos de Gantt, tableros de control (dashboards), análisis
de desempeño del equipo y proyecciones de finalización.

*Notificaciones y Comunicación*
Sistema de alertas para cambios de estado, asignaciones nuevas, vencimientos próximos y
menciones en comentarios.

## Requerimientos No Funcionales

*Seguridad*: Autenticación robusta, control de acceso basado en roles, encriptación de datos 
sensibles y auditoría de acciones.

*Rendimiento*: Respuesta rápida incluso con múltiples proyectos y usuarios concurrentes, carga 
eficiente de datos.

*Escalabilidad*: Capacidad de crecer con más usuarios, proyectos y datos sin degradar el 
rendimiento.

*Usabilidad*: Interfaz intuitiva, accesible, con navegación clara y flujos de trabajo lógicos.

*Disponibilidad*: Alta disponibilidad, copias de seguridad automáticas y recuperación
ante fallos.

## Entidades Principales

*Proyecto*: 
id,
nombre, 
descripción, 
fechaInicio, 
fechaFin,
estado,
presupuesto,
líder,
fechaCreación

*Usuario*: 
id, 
nombre, 
email, 
contraseña (hash), 
rol, 
departamento, 
fechaRegistro, 
activo

*Miembro del Proyecto*: 
id,
usuarioId, 
proyectoId, 
rol, 
fechaAsignación

*Tarea*: 
id, 
proyectoId, 
nombre, 
descripción, 
estado, 
prioridad, 
asignadoA, 
fechaVencimiento,
estimaciónHoras, 
fechaCreación

*Subtarea*: 
id, 
tareaId, 
nombre, 
estado, 
asignadoA

*Dependencia*:
id,
tareaOrigen, 
tareaDestino, 
tipo (bloqueada por, bloqueante)

*Registro de Tiempo*: 
id, 
tareaId, 
usuarioId, 
horasTrabajadas, 
fecha, 
descripción

*Comentario*:
id, 
tareaId, 
usuarioId, 
contenido, 
fecha

*Archivo/Adjunto*: 
id,
proyectoId/tareaId, 
nombreArchivo, 
rutaAlmacenamiento, 
fechaSubida,
usuarioId

*Reporte*: 
id, 
proyectoId, 
tipo, 
fechaGeneración, 
contenido

