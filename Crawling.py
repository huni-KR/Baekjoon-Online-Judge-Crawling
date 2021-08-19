import chromedriver_autoinstaller
import subprocess
import sys

from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from time import sleep


class Data:
    def __init__(self, submitNumber, number, result, memory, time, extension, code):
        self.submitNumber = submitNumber
        self.number = number
        self.result = result
        self.memory = memory
        self.time = time
        self.extension = extension
        self.code = code


def getCode(driver, submitNumber):
    # 제출 코드 이동
    driver.find_element_by_xpath(
        '//*[@id="solution-' + str(submitNumber)+'"]/td[7]/a[2]').click()
    driver.implicitly_wait(10)  # seconds

    lines = driver.find_elements_by_xpath(
        '//*[@id="submit_form"]/div[3]/div/div/div[6]/div[1]/div/div/div/div[5]/div')

    code = ''
    for i in range(1, len(lines)+1):
        line = lines[i-1].find_element_by_xpath(
            '//*[@id="submit_form"]/div[3]/div/div/div[6]/div[1]/div/div/div/div[5]/div[' + str(i) + ']/pre/span').text
        code += line + '\n'

    driver.back()   # 뒤로 가기
    driver.implicitly_wait(10)  # seconds

    return code


def extensionMatch(language):
    for key in extensionDict:
        if key in language:
            return extensionDict[key]
    return 'txt'


def extensionFinder(str):
    language = str.split('/')[0].strip().lower()
    return extensionMatch(language)


def handleProblem(driver, url):
    # 문제페이지 이동
    driver.get(url)
    driver.implicitly_wait(10)  # seconds

    # 내 제출 이동 여기 수정해야함
    text = driver.find_element_by_xpath(
        '/html/body/div[2]/div[2]/div[3]/div[2]/ul/li[7]/a').text

    if text == '내 제출':
        driver.find_element_by_xpath(
            '/html/body/div[2]/div[2]/div[3]/div[2]/ul/li[7]/a').click()
        driver.implicitly_wait(10)  # seconds
    else:
        driver.find_element_by_xpath(
            '/html/body/div[2]/div[2]/div[3]/div[2]/ul/li[8]/a').click()
        driver.implicitly_wait(10)  # seconds

    submits = driver.find_elements_by_xpath('//*[@id="status-table"]/tbody/tr')

    isTop = True
    for i in range(0, len(submits)):
        tds = submits[i].find_elements_by_tag_name("td")
        for j in range(0, len(tds)-1):
            if j == 0:  # submitNumber
                submitNumber = tds[j].text.strip()
            elif j == 2:  # nubmer
                number = tds[j].text.strip()
            elif j == 3:  # result
                result = tds[j].text.strip()
            elif j == 4:  # memory
                memory = tds[j].text.strip()
            elif j == 5:  # time
                time = tds[j].text.strip()
            elif j == 6:  # extension
                extension = extensionFinder(tds[j].text)
            elif j == 7:  # code
                code = getCode(driver, submitNumber)

        if isTop:
            topData = Data(submitNumber, number, result,
                           memory, time, extension, code)
            isTop = False
            if '맞았' in topData.result:
                return topData
        else:
            resultData = Data(submitNumber, number, result,
                              memory, time, extension, code)
            if '맞았' in resultData.result:
                return resultData

        submits = driver.find_elements_by_xpath(
            '//*[@id="status-table"]/tbody/tr')
    return topData


def saveCode(Data):
    if '맞았' in Data.result:
        solvedFile = open('./codes/solved/' + str(Data.number) +
                          '.' + str(Data.extension), 'w')
        solvedFile.write(Data.code)
        solvedFile.close()
    else:
        unsolvedFile = open('./codes/unsolved/' + str(Data.number) +
                            '.' + str(Data.extension), 'w')
        unsolvedFile.write(Data.code)
        unsolvedFile.close()


def codeCollector(driver, problems, xpath):
    for i in range(len(problems)):
        problems = driver.find_elements_by_xpath(xpath)
        urlProblem = problems[i].get_attribute('href')
        print(urlProblem)
        Data = handleProblem(driver, urlProblem)

        saveCode(Data)

        driver.back()   # 뒤로 가기
        driver.implicitly_wait(10)  # seconds

        driver.back()   # 뒤로 가기
        driver.implicitly_wait(10)  # seconds


def problems(driver):
    solvedXpath = '/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[2]/a'
    sovledProblems = driver.find_elements_by_xpath(solvedXpath)
    codeCollector(driver, sovledProblems, solvedXpath)

    unsolvedXpath = '/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div[2]/div[2]/a'
    unsolvedProblems = driver.find_elements_by_xpath(unsolvedXpath)
    codeCollector(driver, unsolvedProblems, unsolvedXpath)


def mypage(driver):
    # 마이페이지 이동
    driver.find_element_by_xpath(
        '/html/body/div[2]/div[1]/div[1]/div/ul/li[1]/a').click()
    driver.implicitly_wait(10)  # seconds

    problems(driver)


def loginCheck(driver):
    isLogin = False
    while(not isLogin):
        if driver.current_url == 'https://www.acmicpc.net/':
            isLogin = True
        else:
            sleep(3)


def login(driver):
    driver.get('https://www.acmicpc.net/login')
    driver.implicitly_wait(10)

    loginCheck(driver)


def crawling(driver):
    login(driver)
    mypage(driver)


def ready():
    subprocess.Popen(
        r'C:\Program Files\Google\Chrome\Application\chrome.exe --remote-debugging-port=9222 --user-data-dir="C:\chrometemp"')  # 디버거 크롬 구동

    option = Options()
    option.add_experimental_option("debuggerAddress", "127.0.0.1:9222")

    chrome_ver = chromedriver_autoinstaller.get_chrome_version().split('.')[0]
    try:
        driver = webdriver.Chrome(
            f'./{chrome_ver}/chromedriver.exe', options=option)
    except:
        chromedriver_autoinstaller.install(True)
        driver = webdriver.Chrome(
            f'./{chrome_ver}/chromedriver.exe', options=option)

    return driver


extensionDict = {'java': 'java', 'c++': 'cpp', 'c': 'c', 'py': 'py'}

crawling(ready())
