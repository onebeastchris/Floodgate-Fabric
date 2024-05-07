plugins {
    `java-library`
    id("net.kyori.indra")
}

dependencies {
    compileOnly("org.checkerframework", "checker-qual", "3.19.0")
}

indra {
    github("GeyserMC", "Floodgate-Modded") {
        ci(true)
        issues(true)
        scm(true)
    }
    mitLicense()

    javaVersions {
        target(21)
    }
}

tasks {
    processResources {
        filesMatching(listOf("fabric.mod.json", "floodgate.mixins.json", "META-INF/neoforge.mods.toml")) {
            expand(
                "id" to "floodgate",
                "name" to "Floodgate",
                "version" to project.version,
                "description" to project.description,
                "url" to "https://geysermc.org",
                "author" to "GeyserMC",
                "minecraft_version" to "1.20.5"
            )
        }
    }
}