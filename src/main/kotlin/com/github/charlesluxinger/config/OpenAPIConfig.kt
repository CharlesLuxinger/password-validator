package com.github.charlesluxinger.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.servers.Server

@OpenAPIDefinition(
    info = Info(
        title = "File Scan Api",
        version = "v1.0.0",
        description = "Password Validator Challenge API",
        contact = Contact(name = "Charles Luxinger", email = "charlesluxinger@gmail.com")
    ),
    servers = [Server(url = "http://localhost:8080/api/v1", description = "Local Server")]
)
class OpenAPIConfig {}