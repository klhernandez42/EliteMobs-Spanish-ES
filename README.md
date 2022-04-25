> **DISCLAIMER:** Esta es una traducción no oficial del reporistorio se aconseja revisar el repositorio de origente MagmaGuy/EliteMobs y revisar su avance. (nota del 25-04-2022)

¡Gracias por usar EliteMobs!

Este complemento está hecho para funcionar desde el principio sin trabajo de configuración adicional y para ser altamente personalizable.

Si desea realizar algunos cambios de configuración profundos en el complemento, intente leer la wiki de GitHub que he creado con anticipación o mientras realiza los cambios para saber qué están haciendo las opciones. 

https://github.com/MagmaGuy/EliteMobs

Si necesita ayuda con este complemento, puede comunicarse conmigo en mi canal de soporte (en inglés) de discord: https://discord.gg/QSA2wgh

Para todo lo relacionado con EliteMobs, puede ir a mi sitio web para encontrar todos los recursos que he puesto a disposición, como la página de github, la wiki, el creador de botín personalizado, etc.

¡Espero que lo disfrutes! Si lo hace, deje una calificación en la página de recursos y/o ¡invíteme un café! (los enlaces de paypal se pueden encontrar en la página de recursos de spigot)

# Notas de Desarrollo:

## API

EliteMobs tiene algunas API básicas para interactuar con el paquete `com.magmaguy.elitemobs.api`. Aquí está el desglose:

### DamageEliteMob

Se utiliza para aplicar daño personalizado a Elite Mobs. Usos:
- Omitir el sistema de daño personalizado de EliteMobs para un evento de daño específico.
- Aplicar una cantidad de daño personalizada recomendada automáticamente que varía según el nivel del jefe.

*Nota:* El daño variable tiene en cuenta el nivel de élite e inflige más daño a los niveles más altos. No tiene en cuenta el multiplicador de salud de los jefes personalizados por motivos de equilibrio.

### EliteMobDamagedByEliteMobEvent

Used for listening to moments when one Elite damages another Elite. Uses:
- Same as Bukkit's EntityDamagedByEntity event but for elites specifically
- Cancelling it might not work. Report if it doesn't.

### EliteMobDamagedByPlayerAntiExploit
Used for listening to events which trigger an antiexploit **check** - doesn't necessarily mean that it detected an exploit. Uses:
- Same as Bukkit's EntityDamagedByEntity event but for elites specifically
- Can be cancelled

### EliteMobDamagedByPlayerEvent:
Used for listening to moments when a player damages an Elite. Uses:

- Same as Bukkit's EntityDamagedByEntity event but for players damaging elites specifically
- ***Important:*** can't be cancelled as it only fires after applying the damage

### EliteMobDamagedEvent:
Used for listening to moments when an elite is damaged in general. Uses:

- Same as Bukkit's EntityDamageEvent
- ***Important*** Cancelling this event might not 100% work, report if it doesn't

### EliteMobDeathEvent:
Used to listening to moments when an elite is killed. Uses:

- Same as Bukkit's EntityDeathEvent.

### EliteMobEnterCombatEvent:
Used for listening to moments when an elite enters combat against a player. Uses:

- Get the target (player only) of the Elite
- Get the elite which entered in combat

#### EliteMobExitCombatEvent:
Used for listening to moments when an elite leaves combat against a player. Uses:

- Get the elite which just let combat.

### EliteMobsItemDetector:
Used for detecting whether an ItemStack is an EliteMobs ItemStack (like a custom item or a procedurally generated item). Uses:

- Detect if an ItemStack is an EliteMobs custom or dynamic item.

### EliteMobSpawnEvent:
Used for detecting when an Elite spawns. USes:

- Detect when an Elite spawns
- Detect which Elite spawned

### EliteMobTargetPlayerEvent:
Used for detecting when an Elite has targetted a player. Uses:

- Detect when an Elite targets a player.
- Cancel an Elite's detection of a player.

### GenericAntiExploitEvent

Used for listening to moments when the antiexploit runs a check but no players damaged it. Uses:

- Detect when the antiexploit is doing a non-player based exploit check
- Cancel an antiexploit check

### PlayerDamagedByEliteMobEvent

Used for listening to moments when players are damaged by an Elite. Uses:

- Same as Bukkit's EntityDamageEvent

---


## To add new item enchantments:
1) Add new enchantment class to the `com.magmaguy.elitemobs.config.enchantments.premade` **extending** `EnchantmentsConfigFields` to initialize create its config file (naming convention: [EnchantmentName]Config)
2) Initialize enchantment in `CustomEnchantment` to initialize the config file
3) Add enchantment class to `com.magmaguy.elitemobs.items.customenchantments` **extending** `CustomEnchantment` to write the logic for the enchantment (naming convention [EnchantmentName]Enchantment)
4) Add a public static String called "key" to register using the ItemTagger class for persistent enchantment tracking
5) Add an customLootEntry to the parseEnchantments() method in `CustomItem` so custom items detect it correctly
6) (Alternative) Add an customLootEntry to `generateCustomEnchantments()` method in `EnchantmentGenerator` if the enchantment should appear in procedurally generated items

Note:
- Don't forget to register events in `EventsRegistrer` if the part with logic in it requires events.
- Don't forget to use the damage bypass if the power is supposed to deal custom damage. Damage dealt by the player to an elite can be overwritten in `CombatSystem` through the static "bypass" boolean field - it makes the next damage dealt to the elite use the raw damage value. For correctly assigning damage, use Bukkit's `Damageable#damage(double amount, Entity source)` and assign the source to your player.

## To add new powers to elites:

to be documented

## To add new events:

to be documented

## To add new default NPCs:

to be documented

## To add new mob types:

to be documented
