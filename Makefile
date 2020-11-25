#!make
define LOGO


#  ██████╗  █████╗ ██████╗ ██╗  ██╗██╗███╗   ██╗ ██████╗     ███████╗██████╗ ██████╗ ██╗███╗   ██╗ ██████╗
#  ██╔══██╗██╔══██╗██╔══██╗██║ ██╔╝██║████╗  ██║██╔════╝     ██╔════╝██╔══██╗██╔══██╗██║████╗  ██║██╔════╝
#  ██████╔╝███████║██████╔╝█████╔╝ ██║██╔██╗ ██║██║  ███╗    ███████╗██████╔╝██████╔╝██║██╔██╗ ██║██║  ███╗
#  ██╔═══╝ ██╔══██║██╔══██╗██╔═██╗ ██║██║╚██╗██║██║   ██║    ╚════██║██╔═══╝ ██╔══██╗██║██║╚██╗██║██║   ██║
#  ██║     ██║  ██║██║  ██║██║  ██╗██║██║ ╚████║╚██████╔╝    ███████║██║     ██║  ██║██║██║ ╚████║╚██████╔╝
#  ╚═╝     ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝ ╚═════╝     ╚══════╝╚═╝     ╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝ ╚═════╝
#

endef

RED='\033[0;31m'         #  ${RED}
GREEN='\033[0;32m'       #  ${GREEN}
YELLOW='\033[0;33m'      #  ${GREEN}
BOLD='\033[1;m'          #  ${BOLD}
WARNING='\033[37;1;41m'  #  ${WARNING}
END_COLOR='\033[0m'      #  ${END_COLOR}
.PHONY: install clean all TAGS info check clean

DOCKER_PATH=docker

DOCKER_COMPOSE_FILES=-f ${DOCKER_PATH}/docker-compose.yml -f ${DOCKER_PATH}/docker-compose.dev.yml

# -p key in docker-compose command is equivalent to --project-name

ifndef PROJECT_NAME
	PROJECT_NAME=parking
endif

ifeq ($(MODE), PROD)
	DOCKER_COMPOSE_FILES=-f ${DOCKER_PATH}/docker-compose.yml -f ${DOCKER_PATH}/docker-compose.prod.yml
endif

export LOGO

all : help

info: # Base info
	@echo ${BOLD}"*********************"${RED}POWERED BY SPRING BOOT${END_COLOR}"**************************"${END_COLOR}
	@echo "$$LOGO"
	@echo ${BOLD}"For getting all commands list run"${GREEN}"make help"${END_COLOR}"or"${GREEN}make listCommands${END_COLOR}${END_COLOR}
	@echo ${BOLD}"If you want start app run"${RED}"make runApp"${END_COLOR}"or"${RED}make run${END_COLOR}"when your containers stopped"${END_COLOR}
	@echo ${BOLD}"Lets go! Have a good codding time..."${END_COLOR}
	@echo ${BOLD}"**********************************************************"${END_COLOR}
.PHONY: info

listCommands help: # List all command call make help or make listCommands ## '^[^\.#[:space:]].*:' - old regex save, maybe useful in future ##
	@$(MAKE)  --no-print-directory info
	@echo ${GREEN}"\nHELP INFORMATION:\n" ${END_COLOR}
	@GREP_COLOR='01;33' grep --color=always  '^[^\.^[:space:]][^:]*:' Makefile | sed G
	@$(MAKE)  --no-print-directory end
.PHONY:listCommands

end: # Print something
	@echo "\n---------------------"${YELLOW}"PARKING APP"${END_COLOR}"2020 ----------------------\n"
.PHONY:end

restart: # Restart containers
	@$(MAKE)  --no-print-directory info
	@echo ${GREEN}"\nRestarting containers...\n" ${END_COLOR}
	@docker-compose -p $(PROJECT_NAME) $(DOCKER_COMPOSE_FILES) restart
	@docker-compose -p $(PROJECT_NAME) $(DOCKER_COMPOSE_FILES) ps
	@$(MAKE)  --no-print-directory end
.PHONY:restart

reload: # Stop, delete and build containers
	@$(MAKE)  --no-print-directory info
	@echo ${GREEN}"\nReloading containers...\n" ${END_COLOR}
	@docker-compose -p $(PROJECT_NAME) $(DOCKER_COMPOSE_FILES) down
	@docker-compose -p $(PROJECT_NAME) $(DOCKER_COMPOSE_FILES) up -d --build
	@$(MAKE)  --no-print-directory end
.PHONY:reload

fullDown: # Stop, delete containers and volumes
	@$(MAKE)  --no-print-directory info
	@echo ${GREEN}"\nStopping containers and delete volumes...\n" ${END_COLOR}
	@docker-compose -p $(PROJECT_NAME) $(DOCKER_COMPOSE_FILES) down -v --rmi all
	@$(MAKE)  --no-print-directory end
.PHONY:down

down: # Stop and remove containers, networks, images, and volumes
	@$(MAKE)  --no-print-directory info
	@echo ${GREEN}"\nStop and remove containers...\n" ${END_COLOR}
	@docker-compose -p $(PROJECT_NAME) $(DOCKER_COMPOSE_FILES) down
	@$(MAKE)  --no-print-directory end
.PHONY:plainDown

stop: # Stop containers
	@$(MAKE)  --no-print-directory info
	@echo ${GREEN}"\nStopping containers...\n" ${END_COLOR}
	@docker-compose -p $(PROJECT_NAME) $(DOCKER_COMPOSE_FILES) stop
	@$(MAKE)  --no-print-directory end
.PHONY:stop

up : run # Run also build containers
.PHONY:up

build:  # Build containers and run
	@$(MAKE)  --no-print-directory info
	@echo ${GREEN}"\nBuild containers...\n" ${END_COLOR}
	@docker-compose -p $(PROJECT_NAME) $(DOCKER_COMPOSE_FILES) stop
	@docker-compose -p $(PROJECT_NAME) $(DOCKER_COMPOSE_FILES) build --no-cache --force
	@docker-compose -p $(PROJECT_NAME) $(DOCKER_COMPOSE_FILES) up -d --build
	@$(MAKE)  --no-print-directory end
.PHONY:build

run:  # Build containers and run
	@$(MAKE)  --no-print-directory info
	@echo ${GREEN}"\nBuild containers...\n" ${END_COLOR}
	@docker-compose -p $(PROJECT_NAME) $(DOCKER_COMPOSE_FILES) up -d --build
	@$(MAKE)  --no-print-directory end
.PHONY:run

ps: # List all containers
	@$(MAKE)  --no-print-directory info
	@echo ${GREEN}"\nContainers \n" ${END_COLOR}
	@docker-compose -p $(PROJECT_NAME) $(DOCKER_COMPOSE_FILES) ps
	@$(MAKE)  --no-print-directory end
.PHONY:ps

socketLogs: # Get server logs
	@$(MAKE)  --no-print-directory info
	@echo ${GREEN}"\nGetting server logs...\n" ${END_COLOR}
	@docker-compose -p $(PROJECT_NAME) $(DOCKER_COMPOSE_FILES)  logs --tail=200 -f nginx
.PHONY:socketLogs

appLogs: # Get app logs
	@$(MAKE)  --no-print-directory info
	@echo ${GREEN}"\nGetting application logs...\n" ${END_COLOR}
	@docker-compose -p $(PROJECT_NAME) $(DOCKER_COMPOSE_FILES)  logs --tail=200 -f app
.PHONY:appLogs

dbLogs: # Get database logs
	@$(MAKE)  --no-print-directory info
	@echo ${GREEN}"\nGetting database logs...\n" ${END_COLOR}
	@docker-compose -p $(PROJECT_NAME) $(DOCKER_COMPOSE_FILES)  logs --tail=200 -f postgres
.PHONY:dbLogs


